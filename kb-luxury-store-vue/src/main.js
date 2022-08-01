import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import Vue2Filters from "vue2-filters";

import { library } from "@fortawesome/fontawesome-svg-core";
import { faCartShopping } from "@fortawesome/free-solid-svg-icons";
import { faXmark } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";

library.add(faCartShopping);
library.add(faXmark);
// library.add(faCartShpping);

Vue.component("font-awesome-icon", FontAwesomeIcon);
Vue.use(Vue2Filters);
Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
