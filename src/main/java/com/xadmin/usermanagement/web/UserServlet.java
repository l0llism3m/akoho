package com.xadmin.usermanagement.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.util.List;

import com.xadmin.usermanagement.bean.Admin;
import com.xadmin.usermanagement.bean.SortStock;
import com.xadmin.usermanagement.bean.Stock;
import com.xadmin.usermanagement.bean.User;
import com.xadmin.usermanagement.dao.UserDao;



@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	 public void init() throws ServletException {
		userDao =new UserDao();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =request.getServletPath();	
		switch(action) 
		{
		case "/new":
			showNewForm(request,response);
			break;
		case "/new1":
			showNewForm1(request,response);
			break;
		case "/new2":
			showNewForm2(request,response);
			break;
		case "/insert":
			try {
				insertUser(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/insert1":
			try {
				insertStock(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/insert2":
			try {
				insertSort(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteUser(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete1":
			try {
				deleteStock(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/delete2":
			try {
				deleteSort(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			showEditForm(request,response);
			break;
		case "/edit1":
			showEditForm1(request,response);
			break;
		case "/edit2":
			showEditForm2(request,response);
			break;
		case "/update":
			try {
				updateUser(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/update1":
			try {
				updateStock(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/update2":
			try {
				updateSort(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/list1":
			try {
				listStock(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/list2":
			try {
				listSort(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "/connecter":
			try {
				listAdmin(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			default:
				try {
					listUser(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
		}
	}
	
	
	 
		//New personnel
		private void showNewForm(HttpServletRequest request ,HttpServletResponse response) throws ServerException , IOException, ServletException{
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
				dispatcher.forward(request, response);
		}
		
		// insert users
		private void insertUser (HttpServletRequest request , HttpServletResponse response) throws SQLException , IOException{
				String name  = request.getParameter("name"); 
				String email = request.getParameter("email");
				String country = request.getParameter("country");
				User newUser = new User (name,email,country);
				userDao.insertUser(newUser);
				response.sendRedirect("list");	
		}	
		
		
		//Update 
		
		private void updateUser(HttpServletRequest request , HttpServletResponse response)
				throws SQLException , IOException{
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name"); 
				String email = request.getParameter("email");
				String country = request.getParameter("country");		
				User user = new User (id,name,email,country);
				userDao.updateUser(user);
				response.sendRedirect("list");
						
						
		}
			
		
		//Delete users
		private void deleteUser(HttpServletRequest request , HttpServletResponse response) throws SQLException , IOException{
				int id = Integer.parseInt(request.getParameter("id")); 
				try {
					userDao.deleteUser(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				response.sendRedirect("list");
		}
	
	
		// edit 
		private void showEditForm(HttpServletRequest request ,HttpServletResponse response) 
				throws ServerException , IOException, ServletException{
			int id= Integer.parseInt(request.getParameter("id"));
			User existingUser;
			try {
				existingUser=userDao.selectUser(id);
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
				request.setAttribute("user", existingUser);
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//new stock
		private void showNewForm1(HttpServletRequest request ,HttpServletResponse response) throws ServerException , IOException, ServletException{
			RequestDispatcher dispatcher = request.getRequestDispatcher("stock-form.jsp");
			dispatcher.forward(request, response);
	}
		
		
		//insert stock
		private void insertStock(HttpServletRequest request , HttpServletResponse response)
				throws SQLException , IOException{
				String nom_persn = request.getParameter("nom_persn"); 
				String nom_prod = request.getParameter("nom_prod");
				String ref_prod = request.getParameter("ref_prod");
				int quant_stk = Integer.parseInt(request.getParameter("quant_stk"));
				int prix_unit = Integer.parseInt(request.getParameter("prix_unit"));
				String date_stk = request.getParameter("date_stk");			
				Stock newstock = new Stock (nom_persn,nom_prod,ref_prod,quant_stk,prix_unit,date_stk);
				userDao.insertStock(newstock);
				response.sendRedirect("list1");
				
				
			}
		//delete stock
		private void deleteStock(HttpServletRequest request , HttpServletResponse response)
				throws SQLException , IOException{
				int id_stk = Integer.parseInt(request.getParameter("id_stk")); 
				userDao.deleteStock(id_stk);
				response.sendRedirect("list1");
			}
		//Edit stock

		private void showEditForm1(HttpServletRequest request ,HttpServletResponse response) 
				throws ServerException , IOException, ServletException{
			int id_stk= Integer.parseInt(request.getParameter("id_stk"));
			Stock existingUser;
			try {
				existingUser=userDao.selectStock(id_stk);
				RequestDispatcher dispatcher = request.getRequestDispatcher("stock-form.jsp");
				request.setAttribute("stock", existingUser);
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Update stock
		private void updateStock(HttpServletRequest request , HttpServletResponse response)
				throws SQLException , IOException{
				int id_stk = Integer.parseInt(request.getParameter("id_stk"));
				String nom_persn = request.getParameter("nom_persn"); 
				String nom_prod = request.getParameter("nom_prod");
				String ref_prod = request.getParameter("ref_prod");
				int quant_stk = Integer.parseInt(request.getParameter("quant_stk"));
				int prix_unit = Integer.parseInt(request.getParameter("prix_unit"));
				String date_stk = request.getParameter("date_stk");
				Stock stock = new Stock (id_stk,nom_persn,nom_prod,ref_prod,quant_stk,prix_unit,date_stk);
				userDao.updateStock(stock);
				response.sendRedirect("list1");
				
				
			}
		
		
		//List of stock
		private void listStock(HttpServletRequest request , HttpServletResponse response) throws SQLException , IOException , ServerException, ServletException{
			
			List<Stock> listStock = userDao.selectAllStock();
			request.setAttribute("listStock", listStock);
			RequestDispatcher dispatcher = request.getRequestDispatcher("stock-list.jsp");
			dispatcher.forward(request, response);
		}
		
	
		
		
		
		
		
		
		//create request of the sort
		
		//New sort
		private void showNewForm2(HttpServletRequest request ,HttpServletResponse response) throws ServerException , IOException, ServletException{
			RequestDispatcher dispatcher = request.getRequestDispatcher("sort-form.jsp");
			dispatcher.forward(request, response);
		}
		
		//insert sort
		private void insertSort (HttpServletRequest request , HttpServletResponse response) throws SQLException , IOException{
			String nom_pers  = request.getParameter("nom_pers"); 
			String nom_prdt = request.getParameter("nom_prodt");
			int quantiter = Integer.parseInt(request.getParameter("quantiter"));
			String date_sort = request.getParameter("date_sort");
			SortStock newSort = new SortStock (nom_pers,nom_prdt,quantiter,date_sort);
			userDao.inserSort(newSort);
			response.sendRedirect("list2");	
		}
		
		//delete sort
		private void deleteSort(HttpServletRequest request , HttpServletResponse response)
			throws SQLException , IOException{
			int id_sort = Integer.parseInt(request.getParameter("id_sort")); 
			userDao.deleteSort(id_sort);
			response.sendRedirect("list2");
		}
		
		// edit 
		private void showEditForm2(HttpServletRequest request ,HttpServletResponse response) 
			throws ServerException , IOException, ServletException{
			int id_sort= Integer.parseInt(request.getParameter("id_sort"));
			SortStock existingUser;
			try {
				existingUser=userDao.selectSort(id_sort);
				RequestDispatcher dispatcher = request.getRequestDispatcher("sort-form.jsp");
				request.setAttribute("sortStock", existingUser);
				dispatcher.forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
			}
		}		
		
		
		//Update stock
	    private void updateSort(HttpServletRequest request , HttpServletResponse response)
			throws SQLException , IOException{
			int id_sort = Integer.parseInt(request.getParameter("id_sort"));
			String nom_pers = request.getParameter("nom_pers"); 
			String nom_prodt = request.getParameter("nom_prodt");
			int quantiter = Integer.parseInt(request.getParameter("quantiter"));
			String date_sort = request.getParameter("date_sort");
			SortStock sortStock = new SortStock (id_sort,nom_pers,nom_prodt,quantiter,date_sort);
			userDao.updateSort(sortStock);
			response.sendRedirect("list2");					
		}
	    
	  //List of sort
	   private void listSort(HttpServletRequest request , HttpServletResponse response) throws SQLException , IOException , ServerException, ServletException{	
	  		List<SortStock> listSort = userDao.selectAllSort();
	  		request.setAttribute("listSort", listSort);
	  		RequestDispatcher dispatcher = request.getRequestDispatcher("sort-list.jsp");
	  		dispatcher.forward(request, response);
	  	}
	   
	   
	   //select all admin
	 //List of stock
	 		private void listAdmin(HttpServletRequest request , HttpServletResponse response) throws SQLException , IOException , ServerException, ServletException{
	 			String loger= request.getParameter("username");
	 			String pass= request.getParameter("password");
	 			String message="Incorrecte email ,veiller resseyer s'il vous plait";
	 			
	 			if (loger.equals("therry") && pass.equals("123456therry") ) {
	 				RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		 			dispatcher.forward(request, response);
				
				}else {
					request.setAttribute("message", message);
					RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		 			dispatcher.forward(request, response);
				}
						 			
	 		}
		
		
	
	   // default 
		private void listUser(HttpServletRequest request , HttpServletResponse response) throws SQLException , IOException{
			
			try {
				List<User>listUser = userDao.selectAllUsers();
				request.setAttribute("listUser", listUser);
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
	
				e.printStackTrace();
			}
		} 
	
	
			
	

}
