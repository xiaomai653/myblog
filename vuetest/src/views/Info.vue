<template>
  <div id="info">
    <Header></Header>
    <div>
      <div>用户：{{userInfo.username}}</div>
      <div style="background-color: white">
        <article v-html="value1"></article>
        <el-button @click="test">test</el-button>
      </div>
      <mavon-editor v-model="value"></mavon-editor>
    </div>
  </div>
</template>

<script>
  import Header from "../components/Header"

  export default {
    name: "Info",
    components: {
      Header
    },
    data() {
      return {
        value: '',
        defaultData: "preview",
        value1: `<p><code>java</code></p>`,
        userInfo: {
          username: ''
        }
      }
    },
    methods: {
      test(event) {
        alert(this.value)
      }
    },
    created() {
      if (this.$store.getters.getUserInfo) {
        this.userInfo = this.$store.getters.getUserInfo
      }
    }
  }
</script>

<style scoped>
  #info div {
    background-color: white;
    border-radius: 10px;
  }

</style>