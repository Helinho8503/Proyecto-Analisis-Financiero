const url = "http://localhost:8080/usuarios"

async function obtener_todos_usuarios (url) {
    const resp = await fetch(url)
    const users = await resp.json()
    return users
  }

function ingresar (users){

    var submit = document.getElementById("singin");

    submit.addEventListener("click", () => {    

    let inputs = document.querySelectorAll('input')
    let loginKeys = {}
    inputs.forEach(input => {
    let texto = input.value.trim()
    if(input.getAttribute('name') == 'email')
    {
        loginKeys.email = texto
    }
    else if(input.getAttribute('name') == 'password')
    {
        loginKeys.password = texto
    }
    })
    for (let i = 0; i < users.length; i++) {
            if (users[i].email == loginKeys.email && users[i].clave == loginKeys.password) {
                console.log("Success!");
                window.location.href = "../pages/index.html?id=" + users[i].id
                return false;
            }
            else{
                console.log("Login Failure!");
            }
        }

    //if (loginKeys.email == "admin@gmail.com" && loginKeys.password == "1234"){
    //    console.log("Success!");
    //    location.href = "../pages/index.html"
    //    return false;
    //}else {
    //    console.log("Login Failure!");
    //    console.log(email);
    //}

});
}

async function main () {
    const users = await obtener_todos_usuarios(url)
    ingresar(users)
  }
  
  main()


