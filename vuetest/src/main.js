import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import axios from 'axios'
import VueAxios from 'vue-axios'
import mavonEditor from 'mavon-editor'

import 'element-ui/lib/theme-chalk/index.css';
import 'mavon-editor/dist/css/index.css'
import './assets/common.css'



Vue.use(VueAxios, axios)

Vue.config.productionTip = false

Vue.use(ElementUI);

Vue.use(mavonEditor)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
