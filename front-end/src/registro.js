const URL_API = "http://localhost:8080/usuarios"


  function getDataForm (e) {
    e.preventDefault()
    const form = e.target
    const persona = {
      nombres: form.user_name.value,
      apellidos: form.user_lastname.value,
      email: form.correo.value,
      clave: form.contraseña.value,
    }
    sendDataCreate(persona)
    clearInputs(form)
  }

  async function sendDataCreate (persona) {
    const resp = await fetch(URL_API, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(persona)
    })
    const text = await resp.text()
    alert(text)
    window.location.href = "../pages/login.html"
  }

  function clearInputs (form) {
    form.nombre.value = ""
    form.apellido.value = ""
    form.email.value = ""
    form.fecha_nacimiento.value = ""
    form.foto.value = ""
  }