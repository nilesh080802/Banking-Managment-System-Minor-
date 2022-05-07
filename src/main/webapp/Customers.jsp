<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- For google icons  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> 



    <title>Create Account For Customers</title>
    <style>
        body {
            padding: 0;
            margin: 0;
            color: rgb(237, 238, 243);
            font-family: Arial, Helvetica, sans-serif;
        }
        
        .background {
            
            
            background: url('./music.jpg') rgba(0, 0, 0, 0.61);
            background-repeat: no-repeat;
            background-size: cover;
            background-blend-mode: darken;
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            z-index: -1;
            filter: blur(3px);
            min-height: 800px;

        }
        
        h2 {
            font-size: 30px;
        }
        
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center;
            background: transparent;
            box-shadow: 0 0 15px rgb(255, 255, 255);
            border-radius: 15px;
            width: 800px;
            margin: 10vh auto;
        }
        
        form {
            padding: 5px;
            display: flex;
            flex-direction: column;
            width: 90%;
        }
        
        .form-item {
            display: flex;
            width: 100%;
            background: transparent;
            margin: 10px auto;
            align-items: center;
            border-radius: 15px;
            border-bottom: 1px solid rgb(82, 81, 81);
        }
        .form-item:hover {
            border: 1px solid rgb(82, 81, 81);;
        }
        input {
            font-size: 18px;
            width: 100%;
            height: 30px;
            outline: none;
            background: transparent;
            border: none;
            margin: auto;
            color: white;
        }
       
        
        span {
            margin: 5px;
            color: rgb(172, 172, 172);
            cursor: default;
            user-select: none;
            background: rgba(85, 81, 81, 0.637);
            padding: 5px;
            border-radius: 15px;
        }
        
        button[type="submit"] {
            width: 200px;
            font-size: 20px;
            margin: 20px auto;
            padding: 10px 16px;
            color: white;
            background: rgba(122, 123, 116, 0.72);
            border: none;
            text-align: center;
        }
        button[type="submit"]:hover {
            background: rgb(170, 134, 8);
        }
        p:first-of-type {
            font-size: 18px;
            margin: 0;
        }
        
        .options {
            display: flex;
            margin:  10px auto;
            flex-wrap: wrap;
            justify-content: center;
        }
        
        button {
            padding: 5px 16px;
            font-size: 18px;
            margin: 5px 15px;
            width: 180px;
            color: white;
            background: transparent;
            cursor: pointer;
            transition: all 0.7s ease;
        }
        .fb:hover{
            background: rgb(5, 5, 73);
            border: none;
            box-shadow: 0 0 5px  rgb(5, 5, 73);
        }

        .gl:hover{
            background: rgb(73, 5, 5);
            border: none;
            box-shadow: 0 0 5px  rgb(73, 5, 5);

        }
        
        p {
            font-size: 18px;
            margin: 5px;
        }
        a{
            color: white;
        }
        a:hover{
            color: grey;
        }

        @media screen and (max-width:550px) {
            .container {
                width: 90%;
            }
            
        }
    </style>

</head>

<body>
    
    <div class="background"></div>
    <div class="container">
        <h2>Create Account</h2>
        
        <form action="${pageContext.request.contextPath }/CustomersController" method="post" class="col-lg-">
               
               <div class="row">
            	<div class="col"> <lable>First Name</lable> </div>
            	<div class="col">	   		          
                <div class="form-item"> <input type="text" name="fname" id="fname" placeholder="Enter your first Name" required></div>
         		</div>
         		
         		</div>
         		<div class="row">
         		<div class="col">Last Name</div>
            	<div class="col">	   		          
                <div class="form-item"><input type="text" name="lname" id="lname" placeholder="Enter your last name" required></div>
         		</div>
         		</div>
         		
         		
         		<div class="row">
         		<div class="col">Email Id</div>
            	<div class="col">	   		          
                <div class="form-item"><input type="email" name="email" id="email" placeholder="Enter email id" required></div>
         		</div>
         		</div>
         		
         		<div class="row">
         		<div class="col">Contact Number</div>
            	<div class="col">	   		          
                <div class="form-item"><input type="text" name="contactNumber" id="contactNumber" placeholder="Enter  Contect number" required></div>
         		</div>
         		</div>
         		
         		<div class="row">
         		<div class="col">Adhaar Number</div>
            	<div class="col">	   		          
                <div class="form-item"><input type="text" name="adharNumber" id="adharNumber" placeholder="Enter Adhar number" required></div>
         		</div>
         		</div>
         		
         		<div class="row">
         		<div class="col">Address</div>
            	<div class="col">	   		          
                <div class="form-item"><input type="text" name="address" id="address" placeholder="Enter Address" required></div>
         		</div>
         		</div>
         		
    
            <div>  <button type="submit">submit </button></div>
            
            </div>
        </form>

    </div>

</body>

</html>