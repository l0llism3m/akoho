<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>gestion de stock</title>
            <style type="text/css">
            	table {
  						border-collapse: collapse;
 						 border-spacing: 0;
  						width: 100%;
 						 border: 1px solid #ddd;
 						 
					}

					th, td {
 						 text-align: left;
 					 padding: 16px;
 					 color:006666;
					}

					tr:nth-child(even) {
  					background-color: #f2f2f2;
					}
					h1{
            padding-top:20px;
              margin-left: 25%;         
            color: 	  #009999;
            letter-spacing: 5px;
            
            line-height: 50px;
            font-family: "Lucida Handwriting", Times, sans-serif;
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
            margin-left: 85%;
        }
    
        
        #myInput {
  			background-repeat: no-repeat;
 		    font-size: 16px;
 		    padding: 12px 20px;
 		    border: 1px solid #ddd;
		    margin-bottom: 12px;
		    margin-left: 65%;
		    position:fixed;
		    margin-top:20px;
		    border-radius: 4px;
		    background-color: 00b3b3;
			}
        
        
        
        
      		  a{
      		  	text-decoration: none;
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

			.main {
			  padding: 16px;
			  margin-top: 30px;
 			 height: 1500px; /* Used in this example to enable scrolling */
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
            <div class="row">
            
             <div class="container">
            		 <div>
                    	<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Chercher par nom.." title="Type in a name" id="myBtn1" class="form-control">
						<button  id="myBtn"> <a href="<%=request.getContextPath()%>/new" class="btn btn-success" >Add New User</a></button>
                    </div>
                    <h1 class="text-center">Listes des Personnels</h3>
                    
                    <hr>
                   
                    <table class="table table-bordered" id="myTable">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Nom</th>
                                <th>Service</th>
                                <th>Contact</th>
                                <th>Actions</th>
                            </tr>
                        </thead> 
                        <tbody>
                            <c:forEach var="user" items="${listUser}">

                                <tr>
                                    <td>
                                        <c:out value="${user.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.email}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.country}" />
                                    </td>
                                    <td>
                                    <a href="edit?id=<c:out value='${user.id}' />">Edit</a>
                                     &nbsp;&nbsp;&nbsp;&nbsp; 
                                     <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                                     </td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
            
            
            
  <script>
	function myFunction() {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInput");
 	 	filter = input.value.toUpperCase();
 	 	table = document.getElementById("myTable");
 	 tr = table.getElementsByTagName("tr");
 		 for (i = 0; i < tr.length; i++) {
  	  td = tr[i].getElementsByTagName("td")[1];
   	 if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
   	   }
 	   }       
	  }
	}
</script>
        </body>

        </html>
