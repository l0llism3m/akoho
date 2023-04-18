<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.xadmin.usermanagement.dao.UserDao" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>gestion de stock</title>
<title>gestion de stock</title>
            <style type="text/css">
          
					h1{
            padding-top:20px;
              margin-left: 25%;         
            color: 	  #009999;
            letter-spacing: 5px;
            
            line-height: 50px;
            font-family: "Lucida Handwriting", Times, sans-serif;
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
			body{
				background-color: #00ffcc;
				
			}
			
            </style>
<script type="text/javascript" src="styles/js/apexchart.js"></script>
</head>
<body>
	<header>
                 
            		<div class="navbar">
 				 	<a href="#home">Gestion stock</a>
 					 <a href="user-list">Personnel</a>
 					 <a href="stock-list">Stock</a>
  					<a href="sort-list.jsp">Stock sort</a>
  					<a href="statistic.jsp">Statistique_stock</a>
  					<a href="statistic1.jsp">Statistique_stock_sort</a>
  					
					</div>
            </header>
            <br>


	<div class="chart"style="background-color:white;width: 100%; height: 100vh;">
		<div class="charts-card" id="data"> 
			<p class="chart-title" style="text-align: center;"><h1>STATISTIQUE SUR LE STOCK</h1></p>
			<div id="bar-chart"></div>
		</div>
	</div>
	<br><br><br><br><br><br>
	
	<script type="text/javascript">

	/*chart*/
 		 // BAR CHART
		  var barChartOptions = {
		  	series: [{
		  	  /* data: [5, 8, 6, 4, 2, 22] */
		  		data: [
 			<%
	       
	 	       Connection con;
	 	       PreparedStatement pst;
	 	       ResultSet rss;
	 	
	 	       Class.forName("com.mysql.cj.jdbc.Driver");
	 	       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionDeStock", "root", "");	 	
	 	       String readData = "SELECT nom_prod,SUM(quant_stk)AS sm FROM stock GROUP by nom_prod";
	 	       Statement st = con.createStatement();
	 	
	 	       rss = st.executeQuery(readData);
	 	       
	 	       while (rss.next()) {
	 	           String id = rss.getString("nom_prod");
	   		%>
		  			<%=rss.getString("sm")  %>,
  			<% } %>
		  		]
		  	}],
		  	chart: {
		  	  type: 'bar',
		  	  height: 350,
		  	  toolbar: {
		  		show: false
		  	  },
		  	},
		  	colors: [
		  	  "#246dec",
		  	  "#cc3c43",
		  	  "#367952",
		  	  "#f5b74f",
		  	  "#4f35a1"
		  	],
		  	plotOptions: {
		  	  bar: {
		  		distributed: true,
		  		borderRadius: 4,
		  		horizontal: false,
		  		columnWidth: '40%',
		  	  }
		  	},
		  	dataLabels: {
		  	  enabled: false
		  	},
		  	legend: {
		  	  show: false
		  	},
		  	xaxis: {
		  	  /* categories: ["Laptop", "Phone", "Monitor", "Headphones", "Camera", "Tablette"],  */
		  	  categories: [
		  		<%
			       
		 	       Connection acon;
		 	       PreparedStatement psta;
		 	       ResultSet ra;
		 	
		 	       Class.forName("com.mysql.cj.jdbc.Driver");
		 	       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionDeStock", "root", "");
		 	
		 	       String Dt = "SELECT nom_prod FROM stock GROUP by nom_prod";
		 	       Statement ts = con.createStatement();
		 	
		 	       ra = st.executeQuery(readData);
		 	       
		 	       while (ra.next()) {
		 	           String id = ra.getString("nom_prod");
		   		%>
		  			"<%=ra.getString("nom_prod") %>",
	  			<% } %>
		  	  ],
		  	},
		  	yaxis: {
		  	  title: {
		  		text: "Count"
		  	  }
		  	}
		    };
		    var barChart = new ApexCharts(document.querySelector("#bar-chart"), barChartOptions);
		    barChart.render();

</script> 
</body>
</html>