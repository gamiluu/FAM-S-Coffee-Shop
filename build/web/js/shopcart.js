listar_json();

//LISTADO DE LOS PRODUCTOS EN BASE A UN JSON DE PRUEBA
async function listar_json(){
      var items = await filtrarProductos()
      console.log(items)
      // Ahora, los datos del archivo JSON están almacenados en la variable 'data'.
      const listado = document.querySelector('.items')
      //Variable que usaremos para obtener subtotal, shipping y el.
      var total_item = 0.00;
      var subtotal = 0.00;
      var shipping = 0.00;
      var total = 0.00;
      // Recorremos el JSON con un forEach para ir creando y listando cada elemento.
      console.log(items.length)
      for (let i = 0; i < items.length; i++) {
        const item = items[i];
        total_item = item.precio * item.cantidad;
        const producto = document.createElement('div');
        producto.classList.add('item');
        producto.setAttribute("id",item.id);
        producto.innerHTML +=`<div class="item_desc"><img src="` + item.url + `" class="item_pic">` + item.nombre +`</div>
                                <div class="item_price">` + item.precio +`€</div>
                                <div class="item_quantity">
                                    <input type="text" value="`+ item.cantidad +`" class="quantity">
                                </div>
                                <div class="item_total">` + total_item.toFixed(2) +`€</div>
                                <img src="./IMG/logos/delete_button.png" class="delete_button" onclick="delete_item(`+ item.id +`)">
                              <div class="hr_items"></div>`;
        listado.appendChild(producto);
        subtotal += parseFloat(total_item.toFixed(2));
        console.log(subtotal.toFixed(2));
      }
      //Mostramos el subtotal.
      document.getElementById("subtotal_value").textContent = subtotal.toFixed(2) + "€";
      //Mostramos el shipping.
      shipping = subtotal * 0.06;
      console.log("Shipping -> " + shipping);
      document.getElementById("shipping_div").textContent = shipping.toFixed(2) + "€";
      //Mostramos el total.
      total = shipping + subtotal;
      console.log("Total -> " + total);
      document.getElementById("total_div").textContent = total.toFixed(2) + "€";
}


//Función con la que eliminamos los elementos de la lista por su ID.
function delete_item(id){
    item = document.getElementById(id);
    item.remove();
    var productos = JSON.parse(localStorage.getItem('productos'));
    var index = productos.indexOf(id);
    if (index !== -1) {
      productos.splice(index, 1);
      localStorage.setItem('productos', JSON.stringify(productos));
    }
}




/**************************************************************/

var productos = JSON.parse(localStorage.getItem('productos'));

async function obtenerResultados() {
  const response = await fetch("Controller?ACTION=PRODUCTOS.FIND_ALL", {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
  });
  const resultados = await response.json();
  return resultados;
}

async function filtrarProductos() {
  const resultados = await obtenerResultados();
  const productosFiltrados = resultados.filter(producto => productos.includes(producto.id));
  return productosFiltrados;
}

