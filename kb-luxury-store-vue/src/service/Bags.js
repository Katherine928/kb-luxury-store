import axios from "axios";
const http = axios.create({
  baseURL: "http://localhost:8080",
});

export default {
  getAllBags() {
    return http.get("/bags");
  },
  getAllWomenBags() {
    return http.get("/bags/women");
  },
  getAllMenBags() {
    return http.get("/bags/men");
  },
  getOnlineBags() {
    return http.get("/bags/online");
  },

  getWomenOnlineBags() {
    return http.get("/bags/women/online");
  },

  getMenOnlineBags() {
    return http.get("/bags/men/online");
  },

  getBagsByColor(color) {
    return http.get("/bags/colors/" + color);
  },

  getOnlineBagsByColor(color) {
    return http.get("/bags/online/" + color);
  },

  addNewBag(bag) {
    return http.post("/bags/add", bag);
  },

  getBagByCategories(item) {
    return http.get("/bags/categories/" + item);
  },

  getOnlineBagByCategories(item) {
    return http.get("/bags/online/categories/" + item);
  },
};
