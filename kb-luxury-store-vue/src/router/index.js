import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import NewView from "../views/NewView.vue";
import WomanView from "../views/WomanView.vue";
import ManView from "../views/ManView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/new",
    name: "new",
    component: NewView,
  },
  {
    path: "/woman",
    name: "woman",
    component: WomanView,
  },
  {
    path: "/man",
    name: "man",
    component: ManView,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
