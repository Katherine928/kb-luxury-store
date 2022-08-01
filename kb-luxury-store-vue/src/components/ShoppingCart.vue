<template>
  <div class="shoppingCart">
    <div class="notification" v-on:click="showCart">
      <font-awesome-icon
        icon="fa-solid fa-cart-shopping"
        size="lg"
        color="black"
      />
      <span class="shppingBag">{{ bagsInShoppingBag.length }}</span>
    </div>
    <transition name="fade" appear>
      <div class="overlay" v-if="this.showForm == true"></div>
    </transition>
    <transition name="slide" appear>
      <div class="cart" v-if="this.showForm == true">
        <div class="cart-header">
          <div class="shoppingBag-header">
            <h1>YOUR SHOPPING BAG</h1>
            <p>({{ bagsInShoppingBag.length }})</p>
          </div>
          <div>
            <button class="btn1" v-on:click="showCart">
              <font-awesome-icon icon="fa-solid fa-xmark" size="3x" />
            </button>
          </div>
        </div>
        <div>
          <div v-if="bagsInShoppingBag.length == 0">
            <h3>Your Shopping Bag is Empty</h3>
          </div>
          <div
            class="container"
            v-for="bag in bagsInShoppingBag"
            v-bind:key="bag.name"
          >
            <div>
              <img v-bind:src="bag.image" alt="" />
              <article class="description">
                <h2>{{ bag.name }}</h2>
                <p>{{ bag.price }}</p>
              </article>
            </div>
            <div>
              <button class="btn2" v-on:click="deleteBag(bag)">
                <font-awesome-icon icon="fa-solid fa-xmark" size="2x" />
              </button>
            </div>
          </div>
        </div>

        <div>
          <div class="price">
            <h2 class="total">TOTAL</h2>
            <h2 class="total-price">{{ total }}</h2>
          </div>
          <div class="check-out"><button class="btn3">CHECK OUT</button></div>
        </div>
      </div>
    </transition>
  </div>
</template>

<script>
import Vue2Filters from "vue2-filters";
export default {
  name: "shopping-cart",
  mixins: [Vue2Filters.mixin],
  data() {
    return {
      showForm: false,
      bagsInShoppingBag: this.$store.state.bagsInShoppingBag,
    };
  },
  computed: {
    total() {
      let sum = 0;
      this.$store.state.bagsInShoppingBag.forEach((bag) => {
        sum += bag.price;
      });
      return sum;
    },
  },
  methods: {
    deleteBag(bag) {
      this.$store.commit("changeStatusAfterDelete", bag);
      this.$store.commit("deleteFromCart", bag);
    },
    showCart() {
      if (this.showForm == true) {
        this.showForm = false;
      } else {
        this.showForm = true;
      }
    },
  },
};
</script>

<style scoped>
.notification {
  display: inline;
  float: right;
  padding: 0 2.2rem;
  position: relative;
  cursor: pointer;
}

span {
  font-size: 0.7em;
  height: 1.5em;
  width: 1.5em;
  border-radius: 100%;
  background-color: rgb(0, 0, 0);
  color: white;
  position: absolute;
  top: -0.7em;
  right: 1.6em;
}

.cart {
  min-height: 100%;
  background-color: white;
  width: 30%;
  height: 100%;
  right: 0;
  top: 0;
  position: fixed;
  z-index: 150;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  overflow-y: scroll;
}

.cart-header {
  border-bottom: 1px solid #a3a2a248;
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  flex-direction: row;
}
.shoppingBag-header {
  display: flex;
  justify-content: baseline;
  padding-left: 50px;
}
img {
  width: 25%;
  float: left;
  display: inline;
  padding: 10px 50px;
}
.container {
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: baseline;
}
.description {
  text-align: left;
  padding-top: 80px;
  display: block;
}
.description h2 {
  font-size: 1.25em;
  font-weight: 700;
  margin-bottom: 0;
}
.description p {
  font-size: 1em;
  font-weight: 700;
}
.btn1 {
  font-size: 1em;
  border: 0px;
  background-color: rgba(231, 230, 230, 0);
  cursor: pointer;
  padding: 20px;
  border-left: 1px solid #a3a2a248;
}
.btn2 {
  background-color: rgba(231, 230, 230, 0);
  cursor: pointer;
  border: 0;
  padding-right: 20px;
}

.btn3 {
  display: block;
  width: 70%;
  padding: 20px 0;
  margin: 0 auto;
  background-color: black;
  color: white;
  margin-bottom: 20px;
  cursor: pointer;
}
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  height: 100%;
  z-index: 100;
  background-color: rgba(0, 0, 0, 0.6);
}
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter,
.fade-leave-to {
  opacity: 0;
}
.slide-enter-active,
.slide-leave-active {
  transition: transform 0.2s;
}
.slide-enter,
.slide-leave-to {
  transform: translateX(50%);
}
.price {
  border-top: 1px solid #a3a2a248;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-between;
  padding: 20px;
}
h3 {
  text-transform: uppercase;
}
</style>
