<template>
  <div id="about">
    <Header></Header>

      <div>
        <el-descriptions class="margin-top" title="带边框列表" :column="3" border style="background-color: white">
          <template slot="extra">
            <el-button type="primary" size="small">操作</el-button>
          </template>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-user"></i>
              用户名
            </template>
            kooriookami
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-mobile-phone"></i>
              手机号
            </template>
            18100000000
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-location-outline"></i>
              居住地
            </template>
            苏州市
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-tickets"></i>
              备注
            </template>
            <el-tag size="small">学校</el-tag>
          </el-descriptions-item>
          <el-descriptions-item>
            <template slot="label">
              <i class="el-icon-office-building"></i>
              联系地址
            </template>
            江苏省苏州市吴中区吴中大道 1188 号
          </el-descriptions-item>
        </el-descriptions>

        <div><h1>This is an about page</h1></div>

        <div> <el-button @click="test" type="primary">主要按钮</el-button></div>

        <el-table
                :data="tableData"
                style="width: 100%">
          <el-table-column
                  prop="product"
                  label="产品"
                  width="180">
          </el-table-column>
          <el-table-column
                  prop="clientName"
                  label="姓名"
                  width="180">
          </el-table-column>
          <el-table-column
                  prop="snCode"
                  label="sn码">
          </el-table-column>
        </el-table>
      </div>

  </div>
</template>


<script>
  import Header from "../components/Header"
  export default {
    name: 'About',
    components: {
      Header
    },
    data() {
      return {
        tableData: []
      }
    },
    methods: {
      test() {
        alert("test")
        this.$store.commit("set_token","123456")
        alert(this.$store.getters.getToken)
        this.$router.push("/")
      }
    },
    // created() {
    //   var _this = this
    //   this.axios.get("http://localhost:9000/getList?page=1&limit=8").then((response) => {
    //     if (response.data.data){
    //       _this.tableData = response.data.data
    //     }
    //   })
    // }
  }
</script>
<style>
  #about{

  }


</style>
