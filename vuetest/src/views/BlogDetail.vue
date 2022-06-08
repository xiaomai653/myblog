<template>
  <div class="detail">
    <div class="nav">
      <div>标题：<el-tag type="success">{{blog.title}}</el-tag></div>
      <div>类型：<el-tag>{{blog.type}}</el-tag></div>
      <div>时间：<el-tag type="info">{{blog.releaseTime}}</el-tag></div>
      <el-link @click="back"  type="primary" :underline="false">返回</el-link>
    </div>
    <div>
      <mavon-editor style="height: 90vh;"
              :value="blog.content"
              defaultOpen="preview"
              :boxShadow="false"
              :editable="false"
              :subfield="false"
              :toolbarsFlag="true"
              :toolbars="toolbars"
              :navigation="true"
      ></mavon-editor>
    </div>
  </div>
</template>

<script>
  export default {
    name: "BlogDetail",
    data(){
      return {
        blog: {
          title: '',
          releaseTime: '',
          content: ''
        },
        toolbars: {
          bold: false, // 粗体
          italic: false, // 斜体
          header: false, // 标题
          underline: false, // 下划线
          strikethrough: false, // 中划线
          mark: false, // 标记
          superscript: false, // 上角标
          subscript: false, // 下角标
          quote: false, // 引用
          ol: false, // 有序列表
          ul: false, // 无序列表
          link: false, // 链接
          imagelink: false, // 图片链接
          code: false, // code
          table: false, // 表格
          fullscreen: false, // 全屏编辑
          readmodel: false, // 沉浸式阅读
          htmlcode: false, // 展示html源码
          help: false, // 帮助
          /* 1.3.5 */
          undo: false, // 上一步
          redo: false, // 下一步
          trash: false, // 清空
          save: false, // 保存（触发events中的save事件）
          /* 1.4.2 */
          navigation: true, // 导航目录
          /* 2.1.8 */
          alignleft: false, // 左对齐
          aligncenter: false, // 居中
          alignright: false, // 右对齐
          /* 2.2.1 */
          subfield: false, // 单双栏模式
          preview: false, // 预览
        }
      }
    },
    methods: {
      back() {
        this.$router.go(-1)
      }
    },
    created() {
      var _this = this
      if (this.$route.query.id){
        this.axios.get('http://localhost:1234/blog/detail', {
          params: {
            id: this.$route.query.id
          }
        }).then(function (res) {
          _this.blog = res.data
        })
      }
    }
  }
</script>

<style scoped>
  .detail {
    max-width: 960px;
    margin: 0 auto;
    background-color: #fbfbfb;
    height: 100vh;
  }

.nav {
  display: flex;
  justify-content: space-around;
  height: 70px;
  line-height: 70px;
}
  .el-tag {
    font-size: 16px;
  }


</style>