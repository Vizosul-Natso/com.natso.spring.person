<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PersonDetails</title>
    <style>
 body{
    margin: 0 0;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: whitesmoke;
}
.form-container{
    border: 4px solid rgb(7, 7, 7);;
    height: 92vh;
    width: 40vw;
    margin-top: 2vh;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
    background-color: #080808;
    border-radius: 3vh;
    box-shadow: 1px 1px 4px 5px rgb(112, 112, 112);
}
#form-heading{
    font-family: cursive;
    font-size: 34px;
    color: white;
    margin-top: 2px;
}
.form1{
    font-family: sans-serif;
    color: rgb(253, 253, 253);
    font: size 24px; 
    border: 3px solid rgb(83, 81, 81);
    border-radius: 20px;
    background-color: #080808;
    margin: 2.5vh;
    display: grid;
    grid-template-columns: repeat(2,1fr);
    grid-gap: 10px;
    padding: 28px;
}
input, select{
    background-color: rgb(147, 147, 151);
    box-shadow: 0px 0px 1px 2px rgba(12, 12, 12, 0.5);
    padding: 7px;
    padding-left: 50px;
    font-family: sans-serif;
    font-size: 18px;
    outline: none;
    border-radius: 12px;
}
label{
    font-family: sans-serif;
    font-size: 18px;
}
.button-container{
    display: flex;
    align-items: center;
    justify-content: center;
}
button{
    border: 2px solid rgb(44, 43, 43);
    height: 7.4vh;
    width: 12vw;
    border-radius: 10px;
    color: whitesmoke;
    background-color: rgb(15, 14, 14);
    font-family: sans-serif;
    font-size: 18px;
    box-shadow:0px 0px 4px 4px rgba(27, 27, 27, 0.8);
}
button:hover{
    filter: brightness(90%);
    cursor: pointer;
}
button:active{
    transform: translateY(1.6px);
}
    </style>
</head>
<body>
    <div class="form-container">
        <h1 id="form-heading">Registration Form</h1>
        <form action="savePerson" class="form" method="post" modelAttribute="person">
            <div class="form1">

                <label for="id">Id</label>
                <input type="number" name="id" id="id">
                <label for="name">Name</label>
                <input type="text" name="name" id="name">
                <label for="age">Age</label>
                <input type="number" name="age" id="age">
                <label for="gender">Gender</label>
                <select name="gender" id="gender">
                  <option value="Male" selected>Male</option>
                  <option value="Female" >Female</option>
                  <option value="Other">Other</option>
                </select>
                <label for="phone">Phone</label>
                <input type="tel" name="phone" id="phone">
                <label for="email">Email</label>
                <input type="email" name="email" id="email">

            </div>  
            <div class="button-container">
                <button type="submit" value="Submit">Register</button>
            </div>
         </form>
    </div>
</body>
</html>