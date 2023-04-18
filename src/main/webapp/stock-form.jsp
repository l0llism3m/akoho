<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@page import="com.xadmin.usermanagement.dao.UserDao"%>
 <%@page import="java.sql.ResultSet"%>
 <!DOCTYPE html>
 <html>
<head>
<meta charset="ISO-8859-1">
<title>gestion de stock</title>
<style type="text/css">
            input[type=text],[type=date],[type=tel],[type=number], select, textarea ,option {
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
                        <c:if test="${stock != null}">
                            <form action="update1" method="post">
                        </c:if>
                        <c:if test="${stock == null}">
                            <form action="insert1" method="post">
                        </c:if>

                        <caption>
                            <h1>
                                <c:if test="${stock != null}">
                                    Modifier produit
                                </c:if>
                                <c:if test="${stock == null}">
                                    Nouveau produit
                                </c:if>
                            </h1>
                        </caption>

                        <c:if test="${stock != null}">
                            <input type="hidden" name="id_stk" value="<c:out value="${stock.id_stk}" />" />
                        </c:if>
                        
                        <fieldset>
                        		<legend style="text-align: center"> Ajout </legend>
                        <table>
                        	
                        		<tr>
                        			<th>
                        				<td><label>Son nom</label></td>                     				
                        				<td>
                        					<select type="text"  id="nom_persn" name="nom_persn" required>
			          						 <%
			        						   	try{
			           								UserDao select= new UserDao();
			           								ResultSet res= select.selectAllUser();
			           		
			           								while(res.next()){ %>
			           								 <option value="<%=res.getString("name") %>"><%=res.getString("name") %></option>
			           				 
			           								<%}
			           		
			           								}catch(Exception e){
			           							e.printStackTrace();
			           							}
			          						 %>
			           
			          					  </select>
                        				
                        				</td>
                        			</th>
                        		</tr>
                        		
                        		<tr>
                        			<th>
                        				<td><label>Nom produit </label></td>
                        				<td><input type="text" value="<c:out value='${stock.nom_prod}' />" class="form-control" name="nom_prod"></td>
                        			</th>
                        		</tr>
                        		<tr>
                        			<th>
                        				<td> <label>Ref produit</label> </td>
                        				<td><input type="text" value="<c:out value='${stock.ref_prod}' />" class="form-control" name="ref_prod"></td>
                        			</th>
                        		</tr>
                        		<tr>
                        			<th>
                        				<td> <label>Quantite </label> </td>
                        				<td><input type="number" value="<c:out value='${stock.quant_stk}' />" class="form-control" name="quant_stk"></td>
                        			</th>
                        		</tr>
                        		<tr>
                        			<th>
                        				<td> <label>Prix unitaire </label> </td>
                        				<td><input type="number" value="<c:out value='${stock.prix_unit}' />" class="form-control" name="prix_unit"></td>
                        			</th>
                        		</tr>
                        		<tr>
                        			<th>
                        				<td> <label>Date </label> </td>
                        				<td><input type="date" value="<c:out value='${stock.date_stk}' />" class="form-control" name="date_stk"></td>
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
