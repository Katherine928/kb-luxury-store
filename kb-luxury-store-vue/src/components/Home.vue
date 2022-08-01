<template>
  <div>
    <div class="bg-video">
      <video class="bg-video_content" autoplay muted loop>
        <source src="../assets/video.mp4" type="video/mp4" />
        Your browser is not supported!
      </video>
    </div>

    <div class="banner">
      <div class="row"><h1>a life full of Fashion</h1></div>
      <button class="btn">Discover the Collection</button>
    </div>
    <div class="video">
      <video class="video_content" autoplay muted loop>
        <source src="../assets/runway.mp4" type="video/mp4" />
        Your browser is not supported!
      </video>
    </div>
    <div class="banner_2">
      <div class="row"><h1>Unique 2022 fashion show</h1></div>
      <button class="btn">Watch the Show</button>
    </div>
    <div class="service">
      <h2>services</h2>
      <div class="cards">
        <div class="service-card">
          <img src="../assets/appointment.jpg" alt="" />
          <h3>Virtual or In-Store Appointments</h3>
          <p>Book a personal shopping experience with our Client Advisor</p>
          <a href="#">Book an Appointment</a>
        </div>
        <div class="service-card">
          <img src="../assets/contact.jpg" alt="" />
          <h3>Contact Us</h3>
          <p>
            Katherine Brooks Luxury Client Advisors are always here to help.
          </p>
          <a href="#">Ask Our Advisors</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "the-home",
};
</script>

<style scoped>
.banner {
  margin-top: 20%;
  text-align: left;
  min-height: 30vh;
}
.banner_2 {
  margin-top: -20%;
  text-align: left;
}
.banner_2 h1 {
  text-transform: uppercase;
  letter-spacing: 0.5em;
  padding: 0 100px;
}
.banner h1 {
  text-transform: uppercase;
  letter-spacing: 0.5em;
  padding: 0 100px;
}
.bg-video {
  position: absolute;
  top: 0;
  left: 0;
  height: 100vh;
  width: 100%;
  z-index: -1;
  opacity: 0.15;
  overflow: hidden;
}
.bg-video_content {
  height: 100%;
  width: 100%;
  object-fit: cover;
}
.video {
  margin-top: 75px;
  height: 50%;
  width: 100%;
  z-index: -1;
  opacity: 0.8;
  overflow: hidden;
}
.video-content {
  height: 50%;
  width: 100%;
  object-fit: cover;
}
.btn {
  display: block;
  width: 20%;
  padding: 20px 0;
  background-color: black;
  color: white;
  cursor: pointer;
  margin-left: 100px;
  margin-top: 50px;
  font-size: 1.3em;
}
img {
  width: 100%;
  opacity: 0.8;
  border: 1px solid #a3a2a248;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2), 0 6px 20px rgba(0, 0, 0, 0.19);
}
.service {
  margin: 0 auto;
  margin-top: 300px;
}
h2 {
  font-size: 2.5em;
  text-transform: uppercase;
  padding: 50px;
  font-weight: 300;
}
.cards {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  width: 100%;
  margin: 0 auto;
  justify-content: center;
  align-items: baseline;
  column-gap: 50px;
}
.service-card {
  width: 45%;
  text-align: left;
}
a {
  color: black;
  text-decoration: none;
  border-bottom: 1px solid black;
}
</style>
