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

    if (loginKeys.email == "admin@gmail.com" && loginKeys.password == "1234"){
        console.log("Success!");
        location.href = "../pages/index.html"
        return false;
    }else {
        console.log("Login Failure!");
        console.log(email);
    }

});



