for (let i = 0; i < 50; i++) { //bucle para crear X productos
    let item = document.createElement("div"); //creamos un div como nuevo elemento
    item.id = "card";   //le damos un id al div creado anteriormente para poder darle estilos en el css y que se vea como una tarjeta de producto

    /*le damos el contenido al div creado anteriormente*/
    item.innerHTML = `
            <div id="img">
                <img src="/web/IMG/products/cm2.png" class="cafetera1">
            </div>
            <div id="content">
                <div id="content_header">
                    <div id="title">Inissia Black</div>
                    <div id="price">47'99€</div>
                </div>
                <div id="content_body">
                    <div id="description">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, voluptatum. Lorem ipsum dolor sit amet consectetur adipisicing elit. Quisquam, voluptatuelit. Quisquam, voluptatum.</div>
                </div>
                <div id="content_footer">
                    <div id="rating">
                        <span style="color:#EFBB02" class="material-symbols-outlined">grade</span>
                        <span style="color:#EFBB02" class="material-symbols-outlined">grade</span>
                        <span style="color:#EFBB02" class="material-symbols-outlined">grade</span>
                        <span style="color:#EFBB02" class="material-symbols-outlined">grade</span>
                        <span style="color:#ffffff" class="material-symbols-outlined">grade</span>
                    </div>
                    <button id="add_cart">Add to cart</button>
                </div>
            </div>
    `;

    document.querySelector(".productos").appendChild(item); //añadimos el div creado anteriormente al div con clase productos
}


/*aqui comienza el script del selector de precios*/

const rangeInput = document.querySelectorAll(".range-input input"),
priceInput = document.querySelectorAll(".price-input input"),
range = document.querySelector(".slider .progress");
let priceGap = 15;
priceInput.forEach(input =>{
    input.addEventListener("input", e =>{
        let minPrice = parseInt(priceInput[0].value),
        maxPrice = parseInt(priceInput[1].value);
        
        if((maxPrice - minPrice >= priceGap) && maxPrice <= rangeInput[1].max){
            if(e.target.className === "input-min"){
                rangeInput[0].value = minPrice;
                range.style.left = ((minPrice / rangeInput[0].max) * 100) + "%";
            }else{
                rangeInput[1].value = maxPrice;
                range.style.right = 100 - (maxPrice / rangeInput[1].max) * 100 + "%";
            }
        }
    });
});
rangeInput.forEach(input =>{
    input.addEventListener("input", e =>{
        let minVal = parseInt(rangeInput[0].value),
        maxVal = parseInt(rangeInput[1].value);
        if((maxVal - minVal) < priceGap){
            if(e.target.className === "range-min"){
                rangeInput[0].value = maxVal - priceGap
            }else{
                rangeInput[1].value = minVal + priceGap;
            }
        }else{
            priceInput[0].value = minVal;
            priceInput[1].value = maxVal;
            range.style.left = ((minVal / rangeInput[0].max) * 100) + "%";
            range.style.right = 100 - (maxVal / rangeInput[1].max) * 100 + "%";
        }
    });
});