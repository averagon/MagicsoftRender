//const services = JSON.parse(localStorage.getItem("services"));
console.log("TEST: Entra al JS");
let productos;
const URL_MAIN='/api/servicios/'; 
function addCard(conjuntoCard){
	console.log("TEST: Entra a function addCard");
	fetch(URL_MAIN,{
		method:'get'
		}).then( function(response){
        response.json()
        .then(function (res){
			console.log("TEST: En fetch");
			console.log(res);
			console.log(res.length);
			productos=res;
			Array.from(res).forEach((p,index)=>{
				conjuntoCard.innerHTML += ` 
				    <div class="col">
			          <div class="card">
			            <div class="card text-dark card-has-bg click-col" style="background-image:url('${p.imagen}');">
			              <div class="card-img-overlay d-flex flex-column">
			                <div class="card-body">
			                  <h4 class="card-title mt-0 "><a class="text-dark" herf="./contacto.html">${p.nombre}</a></h4>
			                  <p>${p.descripcion}</p>
			                </div>
			              </div>
			            </div>
			          </div>
			        </div>`;
			}); //for each
		}); //then
		}).catch(function(error){
			console.log("Problema en el JSON", error)
    });
    	console.log(document.getElementById("cards_servicios"));
    }//addCard
    
   window.addEventListener("load", function(){
	   let conjuntoCard = document.getElementById("cards_servicios");
		addCard(conjuntoCard); 
   });
   
