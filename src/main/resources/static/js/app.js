function login() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://localhost:8080/auth/login', true);
    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                const response = JSON.parse(xhr.responseText);
                alert('Login successful! Token: ' + response.accesToken);
            } else {
                alert('Login failed. Check your credentials.');
            }
        }
    };

    const data = JSON.stringify({ email: email, password: password });
    xhr.send(data);
}
