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