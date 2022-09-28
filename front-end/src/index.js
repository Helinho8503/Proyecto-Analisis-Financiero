const url = "http://localhost:8080/transacciones"
const btn_add_modal = document.querySelector("#btn-add");
const btn_close_modal = document.querySelector("#btn_cerra_modal");
const modal = document.querySelector("#modal");

btn_add_modal.addEventListener("click",abrirmodal);
btn_close_modal.addEventListener("click",cerrarmodal);

function abrirmodal() {
  modal.showModal();
}
function cerrarmodal() { 
  modal.close();
}

function mostrar_transacciones (transacciones) {
    const tabla = document.getElementById('tbody')
    let tbody = ''
    for (let i = 0; i < transacciones.length; i++) {
      const obj = transacciones[i]
      tbody += `
      <tr>
        <td>${obj.razon}</td>
        <td>${obj.monto}</td>
        <td> 
        <button class="btn btn-danger" onclick='deletetransaccion(${obj.id_transaccion})'>Eliminar</button> 
      </td>
      </tr>
    `
    }
    tbody += ''
    tabla.innerHTML = tbody;
  }

  async function obtener_transacciones (url) {
    const search = window.location.search
    const urlsearch = new URLSearchParams(search)
    const id = urlsearch.get("id")
    const resp = await fetch(`${url}?id=${id}&tipo=Ingreso`)
    const transacciones = await resp.json()
    return transacciones
  }

  async function deletetransaccion (id) {
    const resp = await fetch(`${url}/${id}`, {
      method: 'DELETE'
    })
    const text = await resp.text()
    alert(text)
    main()
  }

  function getDataForm (e) {
    const search = window.location.search
    const urlsearch = new URLSearchParams(search)
    const id = urlsearch.get("id")
    e.preventDefault()
    const form = e.target
    const transaccion = {
      id_usuario: id,
      razon: form.razon.value,
      monto: form.monto.value,
      tipo: "Ingreso"
    }
    sendDataCreate(transaccion)
    clearInputs(form)
  }

  async function sendDataCreate (transaccion) {
    const resp = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(transaccion)
    })
    const text = await resp.text()
    alert(text)
    main()
  }

  function clearInputs (form) {
    form.razon.value = ""
    form.monto.value = ""
  }

  async function main () {
    const transacciones = await obtener_transacciones(url)
    mostrar_transacciones(transacciones)
    const search = window.location.search
    const urlsearch = new URLSearchParams(search)
    const id = urlsearch.get("id")
    const referencia = document.getElementById('linkindex')
    referencia.setAttribute('href',"../pages/index2.html?id="+id) 
  }
  
  main()
  