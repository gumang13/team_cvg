function requestCheck() {
    let item = document.getElementById("itemName");
    let feature = document.getElementById("feature");
    let name = document.getElementById("name");
    let tel = document.getElementById("tel");

    if(item.value == '' || feature.value == '' || name.value == '' || tel.value == ''){
    alert("모든 항목을 입력해주세요.");
    return;
}
    alert("주인 확인 요청이 접수되었습니다. 빠른 시일 내에 연락드리겠습니다.");
    location.reload(); // 새로고침

}

