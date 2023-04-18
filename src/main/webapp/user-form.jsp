<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>gestion de stock</title>
<style type="text/css">
            input[type=text],[type=date],[type=tel],[type=number], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid blue;
            border-radius: 4px;
            resize: vertical;
            }
            input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
            box-shadow:12px 10px 12px black;
            }
            input[type=submit]:hover {
            background-color: #45a049;
            }
            input[type=text],[type=date], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid blue;
            border-radius: 4px;
            resize: vertical;
            }
            
            
            
            
                    .navbar {
  			overflow: hidden;
  			background-color: #009999;
 			position: fixed;
  			top: 0;
  			width: 100%;
			}

			.navbar a {
  			float: left;
  			display: block;
  			color: #f2f2f2;
  			text-align: center;
  			padding: 14px 16px;
  			text-decoration: none;
  			font-size: 17px;
			}

			.navbar a:hover {
 			 background: #ddd;
 			 color: black;
			}




			h1{
            padding-top:20px;
                   
            color: 	  #009999;
            letter-spacing: 5px;
            line-height: 50px;
            font-family: "Lucida Handwriting", Times, sans-serif;
            text-align: center;
       		 }
        
        
        
        #myBtn{
            letter-spacing: 5px;
            background-color:#00b3b3;
            position:fixed;
            border:none;
            padding: 12px 20px;
            border-radius: 4px;
            margin-top:20px;
            cursor: pointer;
            box-shadow:8px 8px 12px black;
            margin-left: 35%;
        	}
        	#myBtn1{
            letter-spacing: 5px;
            background-color:#00b3b3;
            position:fixed;
            border:none;
            padding: 12px 20px;
            border-radius: 4px;
            margin-top:20px;
            cursor: pointer;
            box-shadow:8px 8px 12px black;
            margin-left: 55%;
        	}
        	
        	
        	
        	fieldset{
        		margin-left: 30%;
        		width: 30%;
        		padding: 60px ;
        		
        	}
        	
        	body{
        		background-color: #00ffcc;
        	}
        	
	</style>
		</head>
		<body>

            <header>
            		<div class="navbar">
 				 	<a href="#home">Gestion stock</a>
 					 <a href="<%=request.getContextPath()%>/list">Personnel</a>
 					 <a href="<%=request.getContextPath()%>/list1">Stock</a>
  					<a href="<%=request.getContextPath()%>/list2">Stock sort</a>
  					<a href="statistic.jsp">Statistique_stock</a>
  					<a href="statistic1.jsp">Statistique_stock_sort</a>
					</div>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${user != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h1>
                                <c:if test="${user != null}">
                                    Modifier personnel
                                </c:if>
                                <c:if test="${user == null}">
                                    Nouveau personnel
                                </c:if>
                            </h1>
                        </caption>

                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value="${user.id}" />" />
                        </c:if>
                        
                        <fieldset>
                        		<legend style="text-align: center"> Ajout </legend>
                        <table>
                        	
                        		<tr>
                        			<th>
                        				<td><label>Son nom</label></td>
                        				<td><input type="text" value="<c:out value="${user.name}" />" id="input" name="name" required="required"></td>
                        			</th>
                        		</tr>
                        		
                        		<tr>
                        			<th>
                        				<td><label>Son post</label></td>
                        				<td><input type="text" value="<c:out value='${user.email}' />" class="form-control" name="email"></td>
                        			</th>
                        		</tr>
                        		<tr>
                        			<th>
                        				<td> <label>Telephone</label> </td>
                        				<td><input type="number" value="<c:out value='${user.country}' />" class="form-control" name="country"></td>
                        			</th>
                        		</tr>
                        		
                        	
                        
                        </table>
     
                        </fieldset>
                        <button type="submit" class="btn btn-success" id="myBtn" >Enregistrer</button>
                        <button type="reset" class="btn btn-success" id="myBtn1" >Annuler</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>
</html>