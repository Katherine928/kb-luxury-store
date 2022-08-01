import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    bags: [
      {
        name: "PAPILLON",
        image: require("../assets/bag1.jpg"),
        price: 2710,
        cart: false,
      },
      {
        name: "FAVORITE",
        image: require("../assets/bag2.jpg"),
        price: 3250,
        cart: false,
      },
      {
        name: "PALAIS",
        image: require("../assets/bag3.jpg"),
        price: 2840,
        cart: false,
      },
      {
        name: "POCHETTE",
        image: require("../assets/bag4.jpg"),
        price: 2990,
        cart: false,
      },
      {
        name: "MARELLE",
        image: require("../assets/bag5.jpg"),
        price: 3000,
        cart: false,
      },
      {
        name: "ONTHEGO",
        image: require("../assets/bag6.jpg"),
        price: 3950,
        cart: false,
      },
      {
        name: "ALMA",
        image: require("../assets/bag7.jpg"),
        price: 2370,
        cart: false,
      },
      {
        name: "BUCI",
        image: require("../assets/bag8.jpg"),
        price: 4200,
        cart: false,
      },
      {
        name: "MARELLE",
        image: require("../assets/bag9.jpg"),
        price: 2230,
        cart: false,
      },
    ],
    bagsInShoppingBag: [],
    colors: [
      {
        name: "Black",
        image_Url: require("../assets/black.png"),
        active: false,
      },
      {
        name: "White",
        image_Url: require("../assets/white.png"),
        active: false,
      },
      {
        name: "Beige",
        image_Url: require("../assets/beige.png"),
        active: false,
      },
      {
        name: "Red",
        image_Url: require("../assets/red.png"),
        active: false,
      },
      {
        name: "Grey",
        image_Url: require("../assets/grey.png"),
        active: false,
      },
      {
        name: "Brown",
        image_Url: require("../assets/brown.png"),
        active: false,
      },
      {
        name: "Pink",
        image_Url: require("../assets/pink.png"),
        active: false,
      },
      {
        name: "Multicolor",
        image_Url: require("../assets/Multicolor.jpg"),
        active: false,
      },
    ],
    categories: [
      {
        name: "Louis Vuitton",
        image_Url: "https://i.postimg.cc/g0nxqYZd/Louis-Vuitton-Logo.jpg",
        active: false,
      },
      {
        name: "Saint Laurent",
        image_Url: "https://i.postimg.cc/WpMh7YhD/YSL-Logo.png",
        active: false,
      },
    ],
  },

  getters: {},
  mutations: {
    addToShoppingCart(state, bag) {
      state.bagsInShoppingBag.push(bag);
    },

    deleteFromCart(state, bag) {
      // state.bagsInShoppingBag = state.bagsInShoppingBag.filter((item) => {
      //   return item != bag;
      // });
      for (let i = 0; i < state.bagsInShoppingBag.length; i++) {
        if (state.bagsInShoppingBag[i] == bag) {
          state.bagsInShoppingBag.splice(i, 1);
          break;
        }
      }
    },
    changeColorStatus(state, color) {
      for (let i = 0; i < state.colors.length; i++) {
        if (state.colors[i] == color) {
          if (state.colors[i].active == true) {
            state.colors[i].active = false;
          } else {
            state.colors[i].active = true;
          }
        } else {
          state.colors[i].active = false;
        }
      }
    },
    changeCategoriesStatus(state, item) {
      for (let i = 0; i < state.categories.length; i++) {
        if (state.categories[i] == item) {
          if (state.categories[i].active == true) {
            state.categories[i].active = false;
          } else {
            state.categories[i].active = true;
          }
        } else {
          state.categories[i].active = false;
        }
      }
    },
  },
  actions: {},
  modules: {},
});
