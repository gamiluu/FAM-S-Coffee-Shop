const form = document.querySelector('#form');
const usernameInput = document.querySelector('#username');
const passwordInput = document.querySelector('#password');
const emailInput = document.querySelector('#email');

// Manejar el envío del formulario
form.addEventListener('submit', async (event) => {
  // Evitar que el formulario se envíe automáticamente
  event.preventDefault();
  
  // Obtener los valores de entrada del usuario
  const username = usernameInput.value;
  const password = passwordInput.value;
  const email = emailInput.value;

  // Enviar una solicitud al servidor con los detalles de inicio de sesión
  const response = await fetch('Controller?ACTION=LOGIN.LOGIN_USUARIO', {
    method: 'POST',
    body: JSON.stringify({ username, password, email }),
    headers: {
      'Content-Type': 'application/json'
    }
  });

  // Analizar la respuesta JSON del servidor
  const data = await response.json();

  // Comprobar si el inicio de sesión es exitoso
  if (data.success) {
    // Mostrar una alerta de inicio de sesión exitoso
    alert('Has iniciado sesión exitosamente');
  } else {
    // Mostrar un mensaje de error si el inicio de sesión no es exitoso
    alert('Error: ' + data.message);
  }
});