import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: sessionStorage.getItem("token"),
    userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
  },
  mutations: {
    // set
    set_token: (state, token) => {
      state.token = token
      localStorage.setItem("token", token)
    },
    set_userInfo: (state, userInfo) => {
      state.userInfo = userInfo
      localStorage.setItem("userInfo", JSON.stringify(userInfo))
    },
    remove_token: (state) => {
      state.token = ''
      state.userInfo = {}
      localStorage.setItem("token", '')
      localStorage.setItem("userInfo", JSON.stringify(''))
    }
  },
  getters: {
    // get
    getUserInfo: state => {
      return state.userInfo
    },
    getToken: state => {
      return state.token
    }
  },
  actions: {
  },
  modules: {
  }
})
