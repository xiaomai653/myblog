<template>
  <div id="app">
    <!--<el-container>-->
      <!--<login :visible.sync="loginVisible"></login>-->
      <!--<el-header>-->
        <!--<div id="nav">-->
          <!--<div>-->
            <!--<router-link to="/">Home</router-link>-->
            <!--|-->
            <!--<router-link to="/about">About</router-link>-->
            <!--|-->
            <!--<router-link to="/info">Info</router-link>-->
          <!--</div>-->
          <!--<div>-->
            <!--<el-button @click="addBlog" type="success" round>添加</el-button>-->
            <!--<el-button @click="login" type="primary" round>登录</el-button>-->
          <!--</div>-->
        <!--</div>-->
      <!--</el-header>-->
      <!--<el-container class="content">-->
        <!--<div>-->
          <!--<el-aside width="200px">-->
            <!--<div v-for="o in 8" :key="o" class="item">-->
              <!--<el-link href="/about" :underline="false">{{'列表内容 ' + o }}</el-link>-->
            <!--</div>-->
          <!--</el-aside>-->
        <!--</div>-->
        <!--<el-main>-->
          <!--<div>-->
            <!--<router-view/>-->
          <!--</div>-->
        <!--</el-main>-->
      <!--</el-container>-->
      <!--<el-footer>-->
        <!--<div>-->
          <!--<p>这是底部栏</p>-->
        <!--</div>-->
      <!--</el-footer>-->
    <!--</el-container>-->
    <router-view/>

  </div>
</template>

<script>

  import Login from "./views/Login"

  export default {
    components: {Login},
    data() {
      return {
        loginVisible: false,
        userInfo: ''
      }
    },
    methods: {
      addBlog(){
        if (this.$store.getters.getUserInfo){
          this.$router.push("/addBlog")
        } else {
          this.$message({
            message: '请先登录',
            type: 'warning'
          });
        }
      },
      login(){
        this.loginVisible = true
      },
    },
  }
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    background-color: #eef3f8;
  }
</style>
