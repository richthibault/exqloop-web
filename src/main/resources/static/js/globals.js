if (!window.matchMedia('(prefers-reduced-motion: reduce)').matches) {
	setInterval(() => {
		const el = document.querySelector('.flipper');
		if (el) el.classList.toggle('flipped');
	}, 10000);
}

// Nav: transparent → frosted on scroll
const nav = document.getElementById('site-nav');
window.addEventListener('scroll', () => {
	nav.classList.toggle('scrolled', window.scrollY > 50);
}, { passive: true });

// Mobile nav toggle
const toggle = document.getElementById('nav-toggle');
const drawer = document.getElementById('mobile-drawer');

toggle.addEventListener('click', () => {
    const open = toggle.getAttribute('aria-expanded') === 'true';
    toggle.setAttribute('aria-expanded', String(!open));
    drawer.style.display = open ? 'none' : 'block';
    document.getElementById('nav-icon-open').style.display  = open ? 'block' : 'none';
    document.getElementById('nav-icon-close').style.display = open ? 'none'  : 'block';
});

let copyrightYears = document.querySelector('.copyright-years');
const startYear = parseInt(copyrightYears.textContent);
const currentYear = new Date().getFullYear();
if (currentYear > startYear) {
    copyrightYears.textContent = `${startYear} - ${currentYear}`;
}

document.addEventListener('DOMContentLoaded', () => {
	//console.log('Setting active nav link based on current path');
	const currentPath = window.location.pathname;
	document.querySelectorAll('.nav-links a').forEach(link => {
		const linkPath = new URL(link.href).pathname;
		//console.log(`Checking link: ${linkPath} against current path: ${currentPath}`);
		// Exact match for root; prefix match for everything else
		const isActive = linkPath === '/'
			? currentPath === '/'
			: currentPath === linkPath || currentPath.startsWith(linkPath + '/');
		link.classList.toggle('active', isActive);
	});
});