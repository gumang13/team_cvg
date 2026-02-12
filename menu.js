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