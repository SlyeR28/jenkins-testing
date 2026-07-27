document.addEventListener('DOMContentLoaded', () => {
    // Mobile Navbar Toggle
    const mobileToggle = document.getElementById('mobileToggle');
    const navMenu = document.getElementById('navMenu');

    if (mobileToggle && navMenu) {
        mobileToggle.addEventListener('click', () => {
            navMenu.classList.toggle('show');
            const icon = mobileToggle.querySelector('i');
            if (icon) {
                icon.classList.toggle('fa-bars');
                icon.classList.toggle('fa-xmark');
            }
        });
    }

    // Number Counter Animation for Stats
    const statNumbers = document.querySelectorAll('.stat-number');
    
    if (statNumbers.length > 0) {
        const observerOptions = {
            threshold: 0.5
        };

        const observer = new IntersectionObserver((entries, observer) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    const target = entry.target;
                    const countTo = parseInt(target.getAttribute('data-count'), 10);
                    if (isNaN(countTo)) return;

                    let currentCount = 0;
                    const duration = 1500; // ms
                    const stepTime = 20;
                    const increment = countTo / (duration / stepTime);

                    const timer = setInterval(() => {
                        currentCount += increment;
                        if (currentCount >= countTo) {
                            target.innerText = countTo.toLocaleString() + (target.getAttribute('data-suffix') || '');
                            clearInterval(timer);
                        } else {
                            target.innerText = Math.floor(currentCount).toLocaleString() + (target.getAttribute('data-suffix') || '');
                        }
                    }, stepTime);

                    observer.unobserve(target);
                }
            });
        }, observerOptions);

        statNumbers.forEach(stat => observer.observe(stat));
    }

    // Service Tab Filtering (if present)
    const tabBtns = document.querySelectorAll('.tab-btn');
    const serviceCards = document.querySelectorAll('.service-card-item');

    if (tabBtns.length > 0 && serviceCards.length > 0) {
        tabBtns.forEach(btn => {
            btn.addEventListener('click', () => {
                tabBtns.forEach(b => b.classList.remove('active'));
                btn.classList.add('active');

                const category = btn.getAttribute('data-category');
                serviceCards.forEach(card => {
                    if (category === 'all' || card.getAttribute('data-category') === category) {
                        card.style.display = 'block';
                    } else {
                        card.style.display = 'none';
                    }
                });
            });
        });
    }
});
