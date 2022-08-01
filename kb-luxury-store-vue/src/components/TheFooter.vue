<template>
  <div class="footer">
    <div><h1>KATHERINE BROOKS LUXURY</h1></div>
    <div class="contact">
      <p>Contact Us</p>
      <p>Stores</p>
      <p>Apps</p>
      <p>Legal Notice</p>
      <p>Follow Us</p>
      <p>Careers</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "the-footer",
};
</script>

<style scoped>
.footer {
  background-color: black;
  margin-top: 5%;
  height: 20%;
}
.footer > div {
  border-bottom: 1px solid #a3a2a248;
}
.footer > div > h1 {
  text-align: left;
  color: white;
  font-size: 1em;
  padding: 40px 100px;
  letter-spacing: 0.2em;
}
.contact {
  color: white;
  display: flex;
  flex-direction: row;
  align-items: baseline;
  column-gap: 50px;
  justify-content: center;
  padding: 15px;
}
.contact > p {
  cursor: pointer;
}
.contact > p:hover {
  transform: translateY(-5px);
}
</style>
