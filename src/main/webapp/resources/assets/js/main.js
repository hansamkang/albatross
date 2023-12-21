/*
document.getElementById('like-icon').addEventListener('click', function() {
    if(this.textContent === 'favorite_border') {
        this.textContent = 'favorite';
        this.classList.remove('not-liked');
        this.classList.add('liked');
    } else {
        this.textContent = 'favorite_border';
        this.classList.remove('liked');
        this.classList.add('not-liked');
    }
});
*/
document.querySelector('#logOut').addEventListener('click', function() {
    alert("로그아웃 되었습니다.");
    window.location.replace("/Albatross/Logout");
});
