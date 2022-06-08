<template>
  <div id="addBlog">
    <el-form ref="form" :model="form" label-width="80px">
      <el-row>
        <el-col :span="12">
          <el-form-item label="标题">
            <el-input v-model="form.title"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="类型">
            <el-select v-model="form.type" placeholder="请选择类型">
              <el-option label="git" value="git"></el-option>
              <el-option label="前端" value="前端"></el-option>
              <el-option label="后端" value="后端"></el-option>
              <el-option label="数据库" value="数据库"></el-option>
              <el-option label="测试" value="测试"></el-option>
              <el-option label="运维" value="运维"></el-option>
              <el-option label="其他" value="其他"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>


      <el-form-item label="内容">
        <mavon-editor style="height: 600px;" v-model="form.content"></mavon-editor>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button @click="back">取消</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
  export default {
    name: "AddBlog",
    data() {
      return {
        form: {
          title: '',
          type: '',
          author: '',
          releaseTime: new Date(),
          content: ''
        }
      }
    },
    methods: {
      /** 添加一条博客 **/
      onSubmit() {
        this.form.author = this.$store.getters.getUserInfo.username
        this.axios.post("http://localhost:1234/blog/add", this.form).then(res => {
          if (res.data.code === "200") {
            this.$message({
              message: '添加成功',
              type: 'success'
            });
            this.$router.push("/")
          } else {
            this.$message.error('添加失败');
          }


        })
      },
      /** 返回 **/
      back() {
        this.$router.go(-1)
      }
    }
  }
</script>

<style scoped>
  #addBlog {
    height: 100vh;
    max-width: 960px;
    margin: 0 auto;
    display: flex;
    align-items: center;
  }

</style>