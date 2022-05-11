<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
     <%@page import="org.restapi.crud.payment.model.Payment"%>
<!DOCTYPE html>
<html>
<head>
<title>Payment Form</title>
	<link rel="stylesheet" type="text/css" href="Payment.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="Views/bootstrap.min.css">
	<script src="Components/jquery-3.2.1.min.js"></script>
	<script src="Components/jquery-3.5.0.min.js"></script>
	<script src="Components/Payment.js"></script>
</head>
<body>
<img class="wave" src="img/background.jpg" style="width:100%;height:100%;opacity: 0.7">
    	
	<section id="contact" style="position: absolute;top: 8%;left: 5%;right: 100%;trasform: translate(-80%,-80%);width: 1200px;height: 1400px;box-sizing: border-box;background: rgba(0,0,0,0.1);padding: px;"	>
            <div class="container"style="color:black;font-weight: bold;font-weight: 600;" >
                <div class="row">
                    <div class="col-md-6" style="margin-top: 50px;">
                            <div class="img">
                                <img src="img/payment.png">
                            </div>
                    </div>
                    
                   <div class="col-md-6"style="color:black;font-weight: bold;font-weight: 600;" >
                        <form id="formItem" name="formItem" style="color:black;font-weight: bold;font-weight: 600;" >
                                <h1 style=" text-align: center; margin-top: 30px;color: green;font-family: 'Poppins', sans-serif;">Payment Form</h1>                               
                                <div class="form-group" style="width: 510px; margin-left: 15px;">
                                     <label for="From" style="">Enter ID No :</label>
                                     <input id="docId" style="width: 500px;margine-top: 20px;background: transparent;outline: none;padding: 20px;font-size: 13px;border-radius: 30px;box-shadow:0 0 10px #228B22;" name="docId" type="text" class="form-control" placeholder="Id No" required> 
                                </div> 
                                <div class="form-group" style="width: 510px; margin-left: 15px;">
                                     <label for="From"> Enter Name :</label>
                                     <input id="docName" style="width: 500px;margine-top: 20px;background: transparent;outline: none;padding: 20px;font-size: 13px;border-radius: 30px;box-shadow:0 0 10px #228B22;" name="docName"  type="text" class="form-control" placeholder="Username" required>
                                </div>    
                                 
                                 <div class="form-group" style="width: 510px; margin-left: 15px;">
                                      <label for="From">Enter Unit :</label>
                                     <input id="docUnit" style="width: 500px;margine-top: 20px;background: transparent;outline: none;padding: 20px;font-size: 13px;border-radius: 30px;box-shadow:0 0 10px #228B22;" name="docUnit" type="Email" class="form-control" placeholder="Unit" required>
                                </div>
                                
                                <div class="form-group" style="width: 510px; margin-left: 15px;">
                                      <label for="From">Enter Amount :</label>
                                     <input id="docAmount" style="width: 500px;margine-top: 20px;background: transparent;outline: none;padding: 20px;font-size: 13px;border-radius: 30px;box-shadow:0 0 10px #228B22;" name="docAmount" type="text" class="form-control" placeholder="Unit" required>
                                </div>
                                
                                <div class="form-group" style="width: 510px; margin-left: 15px;">
                                      <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-outline-success">
                                      <input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
                                </div>                     
                          
                     </form>    
                <div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
                </div>
            </div>
            <br> 
               
            <div id="divItemsGrid" style="overflow-x:auto;">
					<%
						Payment itemObj = new Payment();
						out.print(itemObj.readPayments());
					%>
            </div> 
        </div>        
        </section>
</body>
</html>