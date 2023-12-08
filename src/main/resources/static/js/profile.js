const storedUser = JSON.parse(localStorage.getItem("user"));
console.log(storedUser);
const userMail = storedUser.email;
console.log(userMail);

if(storedUser == null){
    console.log("Usuario no registrado");
    location.href ='./login.html';
} else {
    console.log(storedUser);//
    insertAdminData(storedUser)
}

function insertAdminData(user){
    let nameAdmin = document.getElementById("userName")
    let phone = document.getElementById("phone");
    let email = document.getElementById("email");
    let pass = document.getElementById("pass");

    nameAdmin.innerHTML = user.nombre;
    
    let inputHTMLPhone = `<input class="form-control" type="text" name="phoneInput" id="phoneInput" value="${user['telefono']}" autocomplete="off" readonly>`
    phone.innerHTML += inputHTMLPhone;
    
    let inputHTMLEmail = `<input class="form-control" type="text" name="emailInput" id="emailInput" value="${user['email']}" autocomplete="off" readonly>`
    email.innerHTML += inputHTMLEmail;
    
    let inputHTMLPass = `<input class="form-control" type="password" name="passInput" id="passInput" value="${user['contraseña']}" autocomplete="off" readonly>`
    pass.innerHTML += inputHTMLPass;
}
