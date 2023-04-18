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
                        <c:if test="${sortStock != null}">
                            <form action="update2" method="post">
                        </c:if>
                        <c:if test="${sortStock == null}">
                            <form action="insert2" method="post">
                        </c:if>

                        <caption>
                            <h1>
                                <c:if test="${sortStock != null}">
                                    Modifier produit sort
                                </c:if>
                                <c:if test="${sortStock == null}">
                                    Nouveau produit sort
                                </c:if>
                            </h1>
                        </caption>

                        <c:if test="${sortStock != null}">
                            <input type="hidden" name="id_sort" value="<c:out value="${sortStock.id_sort}" />" />
                        </c:if>
                        
                        <fieldset>
                        		<legend style="text-align: center"> Ajout </legend>
                        <table>
                        	
                        		<tr>
                        			<th>
                        				<td><label>Son nom</label></td>
                        				<td>
                        					<select type="text"  id="nom_pers" name="nom_pers" required>
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
                        				<td>
                        				
                        					<select id="nom_prod" name="nom_prodt" required>
			          						 <%
			        						   	try{
			           								UserDao select= new UserDao();
			           								ResultSet res= select.selectAllUserr();
			           		
			           								while(res.next()){ %>
			           								 <option value="<%=res.getString("nom_prod") %>"> <%=res.getString("nom_prod") %> / <%=res.getString("ref_prod") %></option>
			           				 
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
                        				<td> <label>Quantite </label> </td>
                        				<td><input type="number" value="<c:out value='${sortStock.quantiter}' />" class="form-control" name="quantiter"></td>
                        			</th>
                        		</tr>
                        		<tr>
                        			<th>
                        				<td> <label>Date </label> </td>
                        				<td><input type="date" value="<c:out value='${sortStock.date_sort}' />" class="form-control" name="date_sort"></td>
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
