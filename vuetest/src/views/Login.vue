<template>
  <div id="login">
    <el-dialog
            title="登录"
            :visible.sync="visible"
            :show-close="false"
            :close-on-click-modal="false"
            :append-to-body="true"
            :close-on-press-escape="false"
            width="30%"
            center>
      <el-form ref="form" :model="form" size="small" label-width="100px">
        <el-row>
          <el-form-item label="用户名：" >
            <el-input class="search-input" v-model="form.username"/>
          </el-form-item>
          <el-form-item label="密码：">
            <el-input type="password" class="search-input" v-model="form.password"/>
          </el-form-item>
        </el-row>
      </el-form>
      <span slot="footer" class="dialog-footer">

    <el-button @click="cancelModel">取 消</el-button>
    <el-button type="primary" @click="login">确 定</el-button>
  </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    name: "Login",
    data() {
      return {
        form: {
          username: 'admin',
          password: '123456'
        }
      }
    },
    props: {
      visible: {
        type: Boolean,
        default: false
      },
    },
    methods: {
      cancelModel() {
        // 关闭弹窗，触发父组件修改visible值
        this.$emit('update:visible',false);
      },
      login() {
        this.axios.post("http://localhost:1234/login",this.form).then(res => {
          if (res.data.code === '200') {
            this.$message({
              message: '登录成功',
              type: 'success'
            });
            this.$store.commit("set_userInfo",res.data.data)
            this.$emit('update:visible',false);
          } else {
            this.$message.error('登录失败');
          }
        })
      }
    }
  }
</script>

<style scoped>


</style>