const url = "http://localhost:8080/transacciones"


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
    const resp = await fetch(`${url}?id=${id}&tipo=Egreso`)
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
  
  async function main () {
    const transacciones = await obtener_transacciones(url)
    mostrar_transacciones(transacciones)
    const search = window.location.search
    const urlsearch = new URLSearchParams(search)
    const id = urlsearch.get("id")
    const referencia = document.getElementById('linkindex')
    referencia.setAttribute('href',"../pages/index.html?id="+id) 
  }
  
  main()
  