const form = document.querySelector('#form');
const usernameInput = document.querySelector('#username');
const passwordInput = document.querySelector('#password');
const emailInput = document.querySelector('#email');

form.addEventListener('submit', async (event) => {
  event.preventDefault();
  const username = usernameInput.value;
  const password = passwordInput.value;
  const email = emailInput.value;
  const response = await fetch("Controller?ACTION=LOGIN.FIND_ALL", {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    });
  const resultados = await response.json();
  const id = resultados.length + 1;
  resultados.forEach(element => {
    if(element.email = email){
      alert("email repetido")
      return;
    }
  });
  const send = await fetch("Controller?ACTION=LOGIN.REGISTER&ID="+id+"&NOMBRE="+username+"&CORREO="+email+"&CONTRASENA="+password , {
    method: 'GET'
  });
});
