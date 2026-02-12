const menu = document.querySelectorAll('.메뉴');


menu.forEach(a => {
   
    a.addEventListener('mouseenter', () => {
        a.style.transform = "scale(1.2)";
        a.style.transition = "transform 0.3s ease";
    });

   
    a.addEventListener('mouseleave', () => {
        a.style.transform = "scale(1.0)";
    });
});


function requestCheck() {
    let lostid = document.getElementById("lostitemid");
    let claimid = document.getElementById("claimid");
    

    if(lostid.value == '' || claimid.value == ''){
    alert("모든 ID를 입력해주세요.");
    return;
}
    alert("반환이 완료되었습니다.");
    location.reload(); // 새로고침

}

function clearInput(){
  document.getElementById("lostitemid").value = "";
  document.getElementById("claimid").value = "";
}
