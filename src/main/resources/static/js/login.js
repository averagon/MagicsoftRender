const loginAlert = document.getElementById("login-alert-container");
let msj_error;

const emailRegEx = /[^@ \t\r\n]+@[^@ \t\r\n]+\.[^@ \t\r\n]+/
const passRegEx = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/
/*Especificaciones: mínimo 8 caracteres, una mayúscula, una minúscula, un número y un caracter especial*/

function showErrorMessage (signAlert, lblError, msj_error){
  lblError.style.border="solid thin red";
  let showAlert = 
    `<div class="alert alert-warning alert-dismissible show" role="alert" id="alert">
    ${msj_error}
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" id="close-warning"></button> </div>`;
    signAlert.insertAdjacentHTML("beforeend",showAlert);
    signAlert.focus();
}//showErrorMessage

function cleanLoginWarnings(){
  loginAlert.innerHTML = "";
  emailLogin.style.border="";
  contraseñaLogin.style.border="";
}//cleanLoginWarnings

function taskcompleted (message){
  Swal.fire({
      position: "top-end",
      icon: "success",
      title: message,
      showConfirmButton: false,
      timer: 1500
    });
}//task completed
 
function validateLogin(mailLogin, passLogin) {
  if(!emailRegEx.test(mailLogin.value) || mailLogin.value.trim().length < 8){
      msj_error="Por favor, verifica tu correo electrónico. El formato correcto es 'usuario@dominio.com'.";
      showErrorMessage(loginAlert, mailLogin, msj_error);
      return false;
  }
  if(!passRegEx.test(passLogin.value)){
      msj_error="La contraseña debe contener: mínimo 8 caracteres, una mayúscula, una minúscula, un número y un caracter especial (#?!@$ %^&*-).";
      showErrorMessage(loginAlert, passLogin, msj_error);
      return false;
  }
  return true;
}//validateLogin

botonLogin.addEventListener("click", function(event){
  event.preventDefault();
  cleanLoginWarnings();
  const mailLogin = document.getElementById("emailLogin");
  const passLogin = document.getElementById("contraseñaLogin");
  const isValid = validateLogin(mailLogin, passLogin);

  if (isValid){
	 var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify({
  "email": mailLogin.value,
  "contraseña": passLogin.value 
});

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
}; 
	console.log("TEST: Entra al JS");
	let adminitradores;
	const URL_MAIN='/api/login/'; 
	  
	  fetch(URL_MAIN, requestOptions)
		.then( function(response){
        response.json()
        .then(function (res){
			console.log("TEST: En fetch");
			console.log(res);
			console.log(res.length);
			adminitradores=res;
			
			if (res.accessToken != null){
				console.log("Correcto");
		          localStorage.setItem("user", JSON.stringify(res.accessToken));
		          location.href ='./gestion.html';
			}else if(res.status == 500){
				msj_error="Usuario y/o contraseña incorrecta";
		          showErrorMessage(loginAlert, passLogin, msj_error);
		          console.log("IncorrectPassword:", msj_error, passLogin.value);	
			}
			
		}); //then
		}).catch(function(error){
			console.log("Problema en el JSON", error);
			msj_error="No existe usuario registrado con este correo";
		      showErrorMessage(loginAlert, mailLogin, msj_error);
		      console.log("MailNotFound:", msj_error, mailLogin.value);
    }); 
	      
   
  }// isValid
});//btnLogin
