(function () {
    const form      = document.getElementById('contact-form');
    const siteKeyEl = document.getElementById('recaptchaSiteKey');
    const tokenEl   = document.getElementById('g-recaptcha-response');

    if (!form) return;

    const submitBtn = form.querySelector('[type="submit"]');

    function disableSubmit() {
        if (submitBtn) {
            submitBtn.disabled = true;
            submitBtn.textContent = 'Sending…';
        }
    }

    form.addEventListener('submit', function (e) {
        e.preventDefault();
        disableSubmit();

        if (siteKeyEl && typeof grecaptcha !== 'undefined') {
            grecaptcha.ready(() => {
                grecaptcha.execute(siteKeyEl.value, { action: 'contact_form_submit' })
                    .then(token => {
                        if (tokenEl) tokenEl.value = token;
                        form.submit();
                    });
            });
        } else {
            form.submit();
        }
    });

})();