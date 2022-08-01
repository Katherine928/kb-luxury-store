<template>
  <div>
    <div>
      <div class="row">
        <h1>ICONIC WOMEN BAGS</h1>
      </div>
      <div class="filter">
        <div><h2>FILTER BY:</h2></div>
        <div class="online">
          <h4>Available Online</h4>
          <input type="checkbox" v-on:click="bagsOnline()" />
        </div>
        <div v-on:click="showCategoriesForm = true">
          <h4>Categories</h4>
        </div>
        <div v-on:click="showColorForm = true"><h4>Colors</h4></div>
      </div>
      <div class="container">
        <bag-card v-for="bag in bags" v-bind:key="bag.id" v-bind:bag="bag" />
      </div>
    </div>
    <div class="color">
      <transition name="fade" appear>
        <div class="overlay" v-if="this.showColorForm == true"></div>
      </transition>
      <transition name="slide" appear>
        <div class="colorList" v-if="this.showColorForm == true">
          <div class="color-header">
            <div class="colorList-header">
              <h1>COLOR</h1>
            </div>
            <div>
              <button class="btn1" v-on:click="closeColor()">
                <font-awesome-icon icon="fa-solid fa-xmark" size="3x" />
              </button>
            </div>
          </div>
          <div class="color-container">
            <div
              class="singleColor"
              v-for="color in colors"
              v-bind:key="color.name"
              v-bind:class="{ 'active-color': color.active }"
            >
              <input
                v-bind:src="color.image_Url"
                v-model="color.name"
                type="image"
                v-on:click="getBagsByColor(color)"
              />
              <p>{{ color.name }}</p>
            </div>
          </div>
          <div class="color-filter">
            <button class="btn3" v-on:click="closeColor()">
              Show {{ this.bags.length }} Product
            </button>
          </div>
        </div>
      </transition>
    </div>
    <div class="color cagegories">
      <transition name="fade" appear>
        <div class="overlay" v-if="this.showCategoriesForm == true"></div>
      </transition>
      <transition name="slide" appear>
        <div class="colorList" v-if="this.showCategoriesForm == true">
          <div class="color-header">
            <div class="colorList-header">
              <h1>CATEGORIES</h1>
            </div>
            <div>
              <button class="btn1" v-on:click="closeCategories">
                <font-awesome-icon icon="fa-solid fa-xmark" size="3x" />
              </button>
            </div>
          </div>
          <div class="color-container">
            <div
              class="singleColor"
              v-for="item in categories"
              v-bind:key="item.name"
              v-bind:class="{ 'active-color': item.active }"
            >
              <input
                v-bind:src="item.image_Url"
                v-model="item.name"
                type="image"
                v-on:click="getBagsByCategories(item)"
              />
              <p>{{ item.name }}</p>
            </div>
          </div>
          <div class="color-filter">
            <button class="btn3" v-on:click="closeCategories">
              Show {{ this.bags.length }} Product
            </button>
          </div>
        </div>
      </transition>
    </div>
    <form v-on:submit:prevent="add">
      <label for="id">id</label>
      <input id="id" type="text" v-model="newBag.bag_id" />
      <label for="name">name</label>
      <input id="name" type="text" v-model="newBag.bag_name" />
      <label for="color">color</label>
      <input id="color" type="text" v-model="newBag.color" />
      <label>price</label>
      <input type="text" v-model="newBag.price" />
      <label>material</label>
      <input type="text" v-model="newBag.material" />
      <label>length</label>
      <input type="text" v-model="newBag.bag_length" />
      <label>height</label>
      <input type="text" v-model="newBag.bag_height" />
      <label>width</label>
      <input type="text" v-model="newBag.bag_width" />
      <label>description</label>
      <input type="text" v-model="newBag.description" />
      <label>image_url</label>
      <input type="text" v-model="newBag.image_url" />
      <label>online</label>
      <input type="text" v-model="newBag.online" />
      <label>categories</label>
      <input type="text" v-model="newBag.categories" />
      <label>iconic</label>
      <input type="text" v-model="newBag.iconic" />
      <button type="submit" v-on:click="add">submit</button>
    </form>
  </div>
</template>

<script>
import BagCard from "./BagCard.vue";
import BagService from "../service/Bags";
export default {
  name: "the-woman",
  components: {
    BagCard,
  },
  data() {
    return {
      bags: {},
      online: false,
      showColorForm: "",
      showCategoriesForm: "",
      newBag: {
        bag_id: "",
        bag_name: "",
        color: "",
        price: "",
        material: "",
        bag_length: "",
        bag_height: "",
        bag_width: "",
        description: "",
        image_url: "",
        online: "",
        categories: "",
        iconic: "",
      },
    };
  },
  computed: {
    colors() {
      return this.$store.state.colors;
    },
    categories() {
      return this.$store.state.categories;
    },
  },
  methods: {
    getBags() {
      BagService.getAllWomenBags().then((response) => {
        this.bags = response.data;
      });
    },
    add() {
      BagService.addNewBag(this.newBag).then((response) => {
        if (response.status === 201 || response.status === 200) {
          this.getBags();
          alert("add it!");
        } else {
          alert("error");
        }
      });
    },
    getBagsByColor(color) {
      this.changeColorStatus(color);
      let name = color.name.toLowerCase();
      if (color.active == true) {
        if (this.online == true) {
          BagService.getOnlineBagsByColor(name).then((response) => {
            this.bags = response.data;
          });
        } else {
          BagService.getBagsByColor(name).then((response) => {
            this.bags = response.data;
          });
        }
      } else {
        if (this.online == true) {
          BagService.getWomenOnlineBags().then((response) => {
            this.bags = response.data;
          });
        } else {
          this.bags = this.getBags();
        }
      }
    },
    getBagsByCategories(item) {
      this.changeCategoriesStatus(item);
      let name = item.name;
      if (item.active == true) {
        if (this.online == true) {
          BagService.getOnlineBagByCategories(name).then((response) => {
            this.bags = response.data;
          });
        } else {
          BagService.getBagByCategories(name).then((response) => {
            this.bags = response.data;
          });
        }
      } else {
        if (this.online == true) {
          BagService.getWomenOnlineBags().then((response) => {
            this.bags = response.data;
          });
        } else {
          this.bags = this.getBags();
        }
      }
    },
    bagsOnline() {
      if (this.online == true) {
        this.bags = this.getBags();
        this.setNotOnline();
      } else {
        BagService.getWomenOnlineBags().then((response) => {
          this.bags = response.data;
        });
        this.setOnline();
      }
    },

    closeColor() {
      this.showColorForm = false;
    },
    closeCategories() {
      this.showCategoriesForm = false;
    },
    setOnline() {
      this.online = true;
    },
    setNotOnline() {
      this.online = false;
    },
    changeColorStatus(color) {
      this.$store.commit("changeColorStatus", color);
    },
    changeCategoriesStatus(item) {
      this.$store.commit("changeCategoriesStatus", item);
    },
  },
  created() {
    this.getBags();
  },
};
</script>

<style scoped>
.filter {
  display: flex;
  flex-wrap: wrap;
  justify-content: right;
  align-items: baseline;
  flex-direction: row;

  border-top: 1px solid #a3a2a248;
  border-bottom: 1px solid #a3a2a248;
  font-weight: 700;
}
.online {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-between;
  column-gap: 10px;
  align-items: baseline;
}
.filter h2 {
  font-size: 1.3em;
  font-weight: 300;
}

.filter div {
  padding: 25px;
}

.filter div:nth-child(3),
.filter div:nth-child(4),
.filter div:nth-child(5),
.filter div:nth-child(6) {
  border-left: 1px solid #a3a2a248;
}

.filter div:nth-child(3):hover,
.filter div:nth-child(4):hover,
.filter div:nth-child(5):hover,
.filter div:nth-child(6):hover {
  border-bottom: 1px solid black;
  cursor: pointer;
}

input[type="checkbox"] {
  width: 3.5em;
  height: 1.5em;
  appearance: none;
  outline: none;
  border-radius: 20px;
  position: relative;
  transform: translateY(10px);
  background: #a3a2a248;
  cursor: pointer;
  transform: translateY(4.5px);
}
input:checked[type="checkbox"] {
  background: black;
}
input[type="checkbox"]:before {
  content: "";
  position: absolute;
  width: 1.8em;
  height: 1.8em;
  border-radius: 50%;
  top: -4px;
  left: 0;
  background-color: #fff;
  transform: scale(1.1);
  border: 1px solid #a3a2a248;
}
input:checked[type="checkbox"]:before {
  left: 1.5em;
}

.row h1 {
  text-align: left;
  margin-left: 50px;
  margin-bottom: 40px;
}
.container {
  margin-top: 50px;
  padding: 10px 50px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  column-gap: 65px;
  row-gap: 75px;
}
.search {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 15%;
  margin-top: 30px;
}
.search_input {
  font-size: 0.8em;
  color: #a3a2a2;
  background-color: #f4f2f2;
  border: none;
  padding: 0.7rem 2rem;
  border-radius: 100px;
  width: 50%;
  margin-right: -3rem;
  transition: all 0.2s;
}
.search_input:focus {
  outline: none;
  width: 100%;
  background-color: #f0eeee;
}
.search_button {
  border: none;
  background-color: #f4f2f2;
}
.search_icon {
  height: 1rem;
  width: 1rem;
  fill: #999;
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
.colorList {
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
.color-header {
  border-bottom: 1px solid #a3a2a248;
  display: flex;
  justify-content: space-between;
  flex-wrap: wrap;
  flex-direction: row;
}
.colorList-header {
  display: flex;
  justify-content: baseline;
  padding-left: 50px;
}
.btn1 {
  font-size: 1em;
  border: 0px;
  background-color: rgba(231, 230, 230, 0);
  cursor: pointer;
  padding: 20px;
  border-left: 1px solid #a3a2a248;
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
.singleColor {
  border: 1px solid #a3a2a248;
  width: 30%;
  padding-top: 20px;
}
.singleColor > input {
  width: 80%;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2), 0 6px 20px rgba(0, 0, 0, 0.19);
}
.singleColor > p {
  text-align: left;
  text-transform: uppercase;
  padding: 5px 0 10px 20px;
  margin: 0;
}
.color-container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  column-gap: 20px;
  row-gap: 20px;
  padding: 20px;
  justify-content: center;
}
.singleColor:hover {
  border: 1px solid black;
}
.active-color {
  border: 1px solid black;
}
</style>
