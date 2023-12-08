
let servicios;
const URL_MAIN='/api/servicios/'; 
fetch(URL_MAIN,{
		method:'get'
		}).then( function(response){
        response.json()
        .then(function (res){
			console.log("TEST: En fetch");
			console.log(res);
			console.log(res.length);
			servicios=res;
			localStorage.setItem("total_servicios", servicios.length);
			insertNumServices(servicios.length);
			
		}); //then
		}).catch(function(error){
			console.log("Problema en el JSON", error)
			var total = "0";
    		insertNumServices(total);
    });


function insertNumServices(totalServices){
	const dataServices = document.getElementById("dataServices");
    console.log("insertando serv:",totalServices);
    const numServices = ` ${totalServices} `;
    dataServices.innerHTML = numServices;
}


const totalAdmins = localStorage.getItem("total_admins");
const dataUsers = document.getElementById("dataUsers");
if (totalAdmins == null) {
    console.log("No hay usuarios registrados en localstorage");
    var total = "0";
    insertNumUsers(total);
}else{
	console.log("total de admins: ",totalAdmins);
    insertNumUsers(totalAdmins);
}
function insertNumUsers(totalAdmins){
	console.log("insertando admins:",totalAdmins);
    const numUsers = ` ${totalAdmins} `;
    dataUsers.innerHTML = numUsers;
}



function loadCotizaciones(cotizrow){
    console.log("TEST: Entra al loadServices JS");
    let cotizaciones;
    const URL_MAIN='/api/cotizacion/'; 
    fetch(URL_MAIN,{
        method:'get'
        }).then( function(response){
        response.json()
        .then(function (res){
            console.log("TEST: En fetch");
            console.log(res);
            console.log(res.length);
            cotizaciones=res;
            localStorage.setItem("total_cotizaciones", cotizaciones.length);
            Array.from(res).forEach((p,index)=>{
                cotizrow.innerHTML += ` 
                <tr>
                    <th class"rowId" scope="row">${p.id}</th>
                    <td >${p.empresa}</td>
                    <td >${p.nombre}</td>
                    <td >${p.email}</td>
                    <td >${p.telefono}</td>
                    <td >${p.mensaje}</td>
                </tr>`;
            }); //for each
        }); //then
        }).catch(function(error){
            console.log("Problema en el JSON", error)
    });
        console.log(document.getElementById("cotiz-table"));  
}//loadCotizaciones

window.addEventListener("load",  function(){
    let cotizrow = document.getElementById("cotiz-table");
    loadCotizaciones(cotizrow); 
    
});//onLoad


setTimeout(() => {
  
  const totalCotiz = localStorage.getItem("total_cotizaciones");
const dataCotiz = document.getElementById("dataCotizaciones");
if (totalCotiz == null) {
    console.log("No hay cotizaciones registrados en la bd");
    var total = "0";
    insertNumCotiz(total);
}else{
	console.log("total de cotizaciones: ",totalCotiz);
    insertNumCotiz(totalCotiz);
}
function insertNumCotiz(totalCotiz){
	console.log("insertando cotizaciones:",totalCotiz);
    const numCotiz = ` ${totalCotiz} `;
    dataCotiz.innerHTML = numCotiz;
}

}, 3000);




