<template>
  <div class="card">
    <img v-bind:src="bag.image_url" alt="" />
    <hr />
    <h2>{{ bag.bag_name }}</h2>
    <p>${{ formatPrice(bag.price) }}</p>
    <button v-on:click="addToCart">
      {{ bag.cart ? "ADDED!" : "ADD" }}
    </button>
  </div>
</template>

<script>
export default {
  name: "bagCard",
  props: ["bag"],
  data() {
    return {
      cart: false,
    };
  },
  methods: {
    addToCart() {
      this.$store.commit("changeStatusAfterAdd", this.bag);
      this.$store.commit("addToShoppingCart", this.bag);
    },
    formatPrice(value) {
      let val = (value / 1).toFixed(2);
      return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
};
</script>

<style scoped>
.card {
  width: 30%;
  line-height: 0.5em;
  text-align: left;
}
img {
  width: 100%;
}
hr {
  border: 1px solid #eeeeee;
}
p {
  display: inline;
}
button {
  display: inline;
  float: right;
  padding: 10px;
  width: 100px;
  background-color: black;
  color: white;
  cursor: pointer;
}
button:hover {
  transform: translateY(-10px);
  transition: all 0.2s;
}
</style>
