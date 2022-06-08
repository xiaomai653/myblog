import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Info from '../views/Info.vue'
import AddBlog from '../views/AddBlog.vue'
import BlogDetail from '../views/BlogDetail.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/info',
    name: 'Info',
    component: Info
  },
  {
    path: '/addBlog',
    name: 'AddBlog',
    component: AddBlog
  },
  {
    path: '/detail',
    name: 'BlogDetail',
    component: BlogDetail
  }
]

const router = new VueRouter({
  routes
})

export default router
