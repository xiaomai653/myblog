<template>
  <div id="home">
    <Header></Header>
    <el-container>
      <div>
        <el-aside width="200px">
          <div class="add">
            <el-button @click="addBlog" type="primary" round>添 加</el-button>
          </div>
          <div class="item" @click="queryType(item.type)" v-for="item in blogType">
            <el-link :underline="false">{{ item.type }}</el-link>
          </div>

        </el-aside>
      </div>
      <el-main>
        <div class="content" @click="BlogDetail(item.id)" v-for="item in blogData">
          <div class="up">
            {{item.title}}
          </div>
          <div class="down">
            <span>作者：{{item.author}}</span>
            <span>分类：{{item.type}}</span>
            <span>时间：{{item.releaseTime}}</span>
          </div>

        </div>
        <div>
          <el-pagination
                  background
                  layout="total, sizes, prev, pager, next, jumper"
                  :current-page.sync="blog.current"
                  :page-sizes="[5, 10, 15, 20]"
                  :page-size="blog.size"
                  :total="blog.total"
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange">
          </el-pagination>
        </div>
      </el-main>
    </el-container>
  </div>
</template>


<script>
  import Header from "../components/Header"


  export default {
    components: {
      Header
    },
    data() {
      return {
        value: new Date(),
        currentDate: new Date(),
        blogData: [],
        blogType: [],
        blog: {
          type: '',
          current: 0,
          size: 10,
          total: 100,
        }
      }
    },
    methods: {
      addBlog() {
        if (this.$store.getters.getUserInfo) {
          this.$router.push("/addBlog")
        } else {
          this.$message({
            message: '请先登录',
            type: 'warning'
          });
        }
      },
      queryType(type) {
        if (this.blog.type === type) {
          this.blog.type = ''
        } else {
          this.blog.type = type
        }
        this.getBlogPage()
      },
      /** 查询博客详情 **/
      BlogDetail(id) {
        // this.$router.push({name:"BlogDetail",params: {id: id}})
        this.$router.push({path: "/detail", query: {id: id}})
      },
      getBlogList(type) {
        var _this = this
        this.axios.post("http://localhost:1234/blog/list", _this.blog).then((res) => {
          if (res) {
            _this.blogData = res.data
          }
        });
      },
      /** 分页获取博客数据 **/
      getBlogPage(type) {
        var _this = this
        this.axios.post("http://localhost:1234/blog/page", _this.blog).then((res) => {
          if (res.data.code === "200") {
            _this.blog.total = res.data.data.total
            _this.blogData = res.data.data.records
          }
        });
      },
      /** 获取博客类型 **/
      async getBlogType() {
        var _this = this
        this.axios.get("http://localhost:1234/blog/getType").then(res => {
          if (res.data.code === "200") {
            _this.blogType = res.data.data
          }
        })
      },
      /** 第几页 **/
      handleCurrentChange(val) {
        this.blog.current = val;
        this.getBlogPage()
      },
      /** 每页显示条数 **/
      handleSizeChange(val) {
        this.blog.size = val;
        this.getBlogPage()
      },
    },
    created() {
      this.getBlogPage();
      this.getBlogType();
    }
  }
</script>
<style>
  #home {
    height: 100%;
    /*color: #333;*/
    /*text-align: center;*/
    /*line-height: 160px;*/
    /*max-width: 960px;*/
    /*margin: 40px auto;*/
    /*padding-top: 60px;*/
  }
  .el-container {
    max-width: 960px;
    margin: 60px auto;
  }

  .el-aside {
    margin-top: 70px;
    position: sticky;
    top: 70px;
  }

  .el-main {

  }

  .item {
    height: 61px;
    line-height: 60px;
    border: 1px solid #eef3f8;
    border-radius: 5px;
    background-color: white;
  }

  .item:hover {
    -webkit-transform: translateY(-3px);
    -ms-transform: translateY(-3px);
    transform: translateY(-3px);
    -webkit-box-shadow: 0 0 6px #999;
    box-shadow: 0 0 6px #999;
    -webkit-transition: all .5s ease-out;
    transition: all .1s ease-out;
  }

  .content {
    background-color: white;
    border-radius: 10px;
    height: 120px;
    margin-bottom: 20px;
  }

  .content:hover {
    -webkit-transform: translateY(-3px);
    -ms-transform: translateY(-3px);
    transform: translateY(-3px);
    -webkit-box-shadow: 0 0 6px #999;
    box-shadow: 0 0 6px #999;
    -webkit-transition: all .5s ease-out;
    transition: all .1s ease-out;
  }
  .up {
    height: 80px;
    line-height: 80px;
    text-align: center;
    font-size: 20px;
  }
  .down {
    height: 24px;
    line-height: 24px;
    display: flex;
    justify-content: space-around;
    font-size: 12px;
  }

  .add {
    width: 100%;
    height: 40px;
    line-height: 40px;
    margin-bottom: 10px;
  }

  .add button {
    width: 100%;
  }

</style>


