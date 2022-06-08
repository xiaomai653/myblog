<template>
  <div id="header">
    <login :visible.sync="loginVisible"></login>
    <div id="nav">
      <div>
        <router-link to="/">Home</router-link>
        |
        <router-link to="/about">About</router-link>
        |
        <router-link to="/info">Info</router-link>
      </div>
      <div>
        <el-button v-if="!$store.state.userInfo" @click="login" type="primary" round>登录</el-button>
        <el-button v-if="$store.state.userInfo"  type="primary" round>{{$store.state.userInfo.username}}</el-button>
      </div>
    </div>
  </div>
</template>

<script>
  import Login from "../views/Login"
  export default {
    name: "Header",
    components: {
      Login
    },
    data() {
      return {
        loginVisible: false
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
    // watch: {
    //   'userInfo.username'(val, oldVal) {
    //     console.log(val)
    //     console.log(oldVal)
    //   }
    // },
    // created() {
    //   if (this.$store.getters.getUserInfo) {
    //     this.userInfo = this.$store.getters.getUserInfo
    //   }
    // }
  }
</script>

<style scoped>

  #header {
    width: 100%;
    background-color: white;
    text-align: center;
    height: 60px;
    line-height: 60px;
    position: fixed;
    top: 0;
    box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.1);
    z-index: 1000;
  }
  #nav {
    width: 80%;
    margin: auto;
    display: flex;
    justify-content: space-between;
  }
  #nav a {
    font-weight: bold;
    color: #2c3e50;
  }
  #nav a.router-link-exact-active {
    color: #42b983;
  }

</style>