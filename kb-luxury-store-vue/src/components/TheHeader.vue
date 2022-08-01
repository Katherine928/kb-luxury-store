<template>
  <div class="header">
    <shopping-cart />
    <div class="row">
      <h1>KATHERINE BROOKS LUXURY</h1>
    </div>
    <nav>
      <ul>
        <router-link tag="li" to="/">Home</router-link>
        <router-link tag="li" to="/new">New</router-link>
        <router-link tag="li" to="/woman">Woman</router-link>
        <router-link tag="li" to="/man">Man</router-link>
      </ul>
    </nav>
  </div>
</template>

<script>
import ShoppingCart from "../components/ShoppingCart.vue";
export default {
  name: "the-header",
  components: {
    ShoppingCart,
  },
};
</script>

<style scoped>
.row {
  width: 80%;
  align-items: center;
  margin: 0 auto;
}
.row h1 {
  padding-top: 20px;
}
nav {
  padding: 10px;
}
ul {
  display: flex;
  flex-direction: row;
  height: 50px;
  justify-content: center;
  column-gap: 80px;
  flex-wrap: wrap;
  border-bottom: 1px solid #a3a2a248;
}
ul li {
  list-style: none;
  font-size: 1em;
  font-weight: 700;
  color: #a3a2a2;
  padding: 15px 40px;
  cursor: pointer;
}
hr {
  border: 1px solid #eeeeee;
}

li.router-link-exact-active {
  background-color: black;
  color: white;
}
</style>
