window.onload = function () {
  let dd = document.getElementById("dropdown");
  let sm = document.getElementById("soulMenu");
  let dm = document.getElementById("daejeonMenu");
  let bm = document.getElementById("busanMenu");
  let im = document.getElementById("inchonMenu");
  let jm = document.getElementById("jejuMenu");
  let bt = document.getElementById("button");
  const cgbt = document.querySelectorAll(".categoryButton");
  let itemName = document.getElementById("1");
  let feature = document.getElementById("2");
  let day = document.getElementById("3");

  cgbt.forEach((btn) => {
    btn.addEventListener("click", function () {
      this.classList.toggle("active");
    });
  });

  bt.addEventListener("click", function () {
    var count = 0;
    if (itemName.value != "") count++;
    if (feature.value != "") count++;
    if (day.value != "") count++;
    if (dd.value != "") count++;

    if (count === 4) {
      alert("접수가 완료되었습니다");
      return;
    } else {
      alert("입력되지않은 정보가 있습니다.");
      return;
    }
  });

  dd.addEventListener("change", function () {
    if (dd.value === "seoul") {
      sm.style.display = "block";
    } else {
      sm.style.display = "none";
    }
    if (dd.value === "daejeon") {
      dm.style.display = "block";
    } else {
      dm.style.display = "none";
    }
    if (dd.value === "busan") {
      bm.style.display = "block";
    } else {
      bm.style.display = "none";
    }
    if (dd.value === "inchon") {
      im.style.display = "block";
    } else {
      im.style.display = "none";
    }
    if (dd.value === "jeju") {
      jm.style.display = "block";
    } else {
      jm.style.display = "none";
    }
  });
};

