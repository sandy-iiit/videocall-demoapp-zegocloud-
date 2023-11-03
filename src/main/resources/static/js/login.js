
function handleLogin(event){
    event.preventDefault()

    const email=document.getElementById("email").value
    const password=document.getElementById("password").value

    const user={
        email:email,
        password:password
    }

    fetch("http://localhost:3000/api/v1/users/login",{
        method:"POST",
        headers:{
            'Content-Type':'application/json'
        },
        body:JSON.stringify(user)
    }).then(response=>{
        if(!response.ok){
            alert("Invalid credentials!!!")
        }
        return response.json()

    }).then((response)=>{
        localStorage.setItem('connectedUser',JSON.stringify(response))
        window.location.href= 'index.html'

    }).catch(err=>{
        console.log(err)
    })

}


const loginform=document.getElementById("loginForm")
loginform.addEventListener("submit",handleLogin)