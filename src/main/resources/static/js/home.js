// Hero: subtle zoom-in on load
requestAnimationFrame(() => {
	document.getElementById('hero-bg').classList.add('loaded');
});

// Respect reduced-motion
if (window.matchMedia('(prefers-reduced-motion: reduce)').matches) {
	document.querySelector('.marquee-track').style.animation = 'none';
	document.querySelector('.hero-bg').style.transition = 'none';
}