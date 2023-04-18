package com.xadmin.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.usermanagement.bean.Admin;
import com.xadmin.usermanagement.bean.SortStock;
import com.xadmin.usermanagement.bean.Stock;
import com.xadmin.usermanagement.bean.User;



public class UserDao {
	private String jdbcURL="jdbc:mysql://localhost:3306/audiotheque?userSSL=false";
	private String jdbcUsername="root";
	private String jdbcPassword="";
	private String jdbcDriver="com.mysql.jdbc.Driver";
	
	
	private static final String INSERT_USERS_SQL=" INSERT INTO user "+" (username , name , email , password) VALUES "+" (?,?,?,?)";
	private static final String SELECT_USER_BY_ID =" select username , name , email ,password from user where uid=? ";
	private static final String SELECT_ALL_USERS =" select username , name , email ,password from user; ";
	private static final String DELETE_USERS_SQL ="delete from users where uid=?;";
	private static final String UPDATE_USERS_SQL = "update users set username = ?, name = ?, email=?, password =? where uid = ?;";
	 //create request of the stock
	private static final String INSERT_MUSIC_SQL=" INSERT INTO music "+" (titre,artiste,path) VALUES "+" (?,?,?)";
	private static final String SELECT_MUSIC_BY_ID =" select titre,artiste from music where id=? ";
	private static final String SELECT_MUSIC_USERS =" select titre, artiste from music ";
	private static final String DELETE_MUSIC_SQL ="delete from music where uid =?";
	private static final String UPDATE_MUSIC_SQL ="update stock set titre= ?, artist=?  where uid=?";
	
	
	
	
	// Connection  
	
	protected Connection getConnection() {
		
		Connection connection =null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername,jdbcPassword);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace(); 
		}
		
		return connection;
	}
	
	
	
	
	
	//insert users 
	
	public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);) {
        	preparedStatement.setString(1, user.getName());
        	preparedStatement.setString(2, user.getEmail());
            	preparedStatement.setString(3, user.getCountry());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                printSQLException(e);
            }
        }

	
	//select user by id

	public User selectUser (int id) {
		User user =null;
		//step 1: Establishing a connection
		try ( Connection connection =getConnection();
				//Step 2: Create a statement using connection object 
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER_BY_ID);){
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// step 3: Execute the query or update query 
			ResultSet rs = preparedStatement.executeQuery();
			// step 4: Process the ResultSet objet 
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country =rs.getString("country");
				user = new User(id , name , email , country);
			}
			
		} catch (SQLException e) {
			printSQLException (e);
		}
		return user;
		
	}	
	//select pour le select 
	public ResultSet selectAllUser() throws SQLException {
		ResultSet rs= null;
		String requete= "SELECT * FROM users";
		Connection connection = getConnection();
		PreparedStatement pStm = connection.prepareStatement(requete);
		rs= pStm.executeQuery();	
		return rs;
	}
	public ResultSet selectAllUserr() throws SQLException {
		ResultSet rs= null;
		String requete= "SELECT * FROM stock";
		Connection connection = getConnection();
		PreparedStatement pStm = connection.prepareStatement(requete);
		rs= pStm.executeQuery();	
		return rs;
	}
	
	
	
	public List<User> selectAllUsers() {
		List<User> users=new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id =rs.getInt("id");
				String name =rs.getString("name");
				String email =rs.getString("email");
				String country =rs.getString("country");
				users.add(new User ( id ,name , email , country) );
			}
			
		} catch (SQLException e) {
			printSQLException (e);
		}
		return users; 
		
	}
	
	
	//update user 
	public boolean updateUser(User user ) throws SQLException{
		boolean rowUpdate;
		try( Connection connection = getConnection();
				PreparedStatement statement =connection.prepareStatement(UPDATE_USERS_SQL)){
			System.out.println("update User" +statement);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getCountry());
			statement.setInt(4, user.getId());
			System.out.println(statement);
			rowUpdate=statement.executeUpdate() >0;	
		}
		return rowUpdate;
	
	}
	
	
	//delete user 
	
	public boolean deleteUser(int id)throws SQLException{
		boolean rowDeleted;
		try (Connection connection =getConnection() ;
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL)){
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate()>0;
		}
		return rowDeleted;
	}
	
	
	// create request of the stock
	//insert stock 
	
		public void insertStock(Stock stock ) throws SQLException{
			System.out.println(INSERT_STOCK_SQL);
			try( Connection connection = getConnection();
					PreparedStatement preparedStatement =connection.prepareStatement(INSERT_STOCK_SQL)){
				preparedStatement.setString(1, stock.getNom_persn());
				preparedStatement.setString(2, stock.getNom_prod());
				preparedStatement.setString(3, stock.getRef_prod());
				preparedStatement.setInt(4, stock.getQuant_stk());
				preparedStatement.setInt(5, stock.getPrix_unit());
				preparedStatement.setString(6, stock.getDate_stk());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			}catch (SQLException e) {
				printSQLException (e);
			}
		}
		
		// Select produit par son identifient 
		public Stock selectStock(int id_stk) {
			Stock stock =null;
			try (Connection connection = getConnection();
					PreparedStatement prepareStatement = connection.prepareStatement(SELECT_STOCK_BY_ID) ){
				prepareStatement.setInt(1, id_stk); 
				
				System.out.println(prepareStatement);
				ResultSet rs = prepareStatement.executeQuery();
				
				while (rs.next()) {
					String nom_persn =rs.getString("nom_persn");
					String nom_prod =rs.getString("nom_prod");
					String ref_prod =rs.getString("ref_prod");
					int quant_stk =rs.getInt("quant_stk");
					int prix_unit =rs.getInt("prix_unit");
					String date_stk =rs.getString("date_stk");
					
					stock = new Stock (id_stk,nom_persn,nom_prod,ref_prod,quant_stk,prix_unit,date_stk);
				}
				
			} catch (SQLException e) {
				printSQLException (e);
			}
			return stock;
			
		}
		
		//select tout le produit 
		
		public List<Stock> selectAllStock() {
			List<Stock> stock=new ArrayList<>();
			try (Connection connection = getConnection();
					PreparedStatement prepareStatement = connection.prepareStatement(SELECT_STOCK_USERS) ){
				System.out.println(prepareStatement);
				ResultSet rs = prepareStatement.executeQuery();
				
				while (rs.next()) {
					int id_stk =rs.getInt("id_stk");
					String nom_persn =rs.getString("nom_persn");
					String nom_prod =rs.getString("nom_prod");
					String ref_prod =rs.getString("ref_prod");
					int quant_stk =rs.getInt("quant_stk");
					int prix_unit =rs.getInt("prix_unit");
					String date_stk =rs.getString("date_stk");
					
					stock.add(new Stock (id_stk,nom_persn,nom_prod,ref_prod,quant_stk,prix_unit,date_stk));
				}
				
			} catch (SQLException e) {
				printSQLException (e);
			}
			return stock; 
			
		}
		
		//create update produit  
				public boolean updateStock(Stock stock ) throws SQLException{
					boolean rowUpdate;
					try( Connection connection = getConnection();
							PreparedStatement statement =connection.prepareStatement(UPDATE_STOCK_SQL)){
						statement.setString(1, stock.getNom_persn());
						statement.setString(2, stock.getNom_prod());
						statement.setString(3, stock.getRef_prod());
						statement.setInt(4, stock.getQuant_stk());
						statement.setInt(5, stock.getPrix_unit());
						statement.setString(6, stock.getDate_stk());
						statement.setInt(7, stock.getId_stk());	
						rowUpdate=statement.executeUpdate() > 0;	
					}
					return rowUpdate;
				
				}
				
				//Supprime produit 
				
				public boolean deleteStock(int id_stk)throws SQLException{
					boolean rowDeleted;
					try (Connection connection =getConnection() ;
							PreparedStatement statement = connection.prepareStatement(DELETE_STOCK_SQL)){
						statement.setInt(1, id_stk);
						rowDeleted = statement.executeUpdate()>0;
					}
					return rowDeleted;
				}
				
				
				
				
				// create request of the stock sort
				//insert sort 
				
					public void inserSort(SortStock sortStock ) throws SQLException{
						System.out.println(INSERT_SORT_SQL);
						try( Connection connection = getConnection(); PreparedStatement preparedStatement =connection.prepareStatement(INSERT_SORT_SQL)){
								preparedStatement.setString(1, sortStock.getNom_pers());
								preparedStatement.setString(2, sortStock.getNom_prodt());
								preparedStatement.setInt(3, sortStock.getQuantiter());
								preparedStatement.setString(4, sortStock.getDate_sort());
								System.out.println(preparedStatement);
								
								PreparedStatement preparedStatement1 =connection.prepareStatement(UPDATE_STOCK_COUNT_SQL);
								preparedStatement1.setInt(1, sortStock.getQuantiter());
								preparedStatement1.setString(2, sortStock.getNom_prodt());
								preparedStatement1.execute();
								System.out.println("here " + preparedStatement);
							
							preparedStatement.executeUpdate();
						}catch (SQLException e) {
							printSQLException (e);
						}
					}
					
					// Select Sort par son identifient 
					
					public SortStock selectSort(int id_sort) {
						SortStock sortStock =null;
						try (Connection connection = getConnection();
								PreparedStatement prepareStatement = connection.prepareStatement(SELECT_SORT_BY_ID) ){
							prepareStatement.setInt(1, id_sort); 							
							System.out.println(prepareStatement);
							ResultSet rs = prepareStatement.executeQuery();							
							while (rs.next()) {
								String nom_pers =rs.getString("nom_pers");
								String nom_prodt =rs.getString("nom_prodt");
								int quantiter =rs.getInt("quantiter");
								String date_sort =rs.getString("date_sort");								
								sortStock = new SortStock (nom_pers,nom_prodt,quantiter,date_sort);
							}	
						} catch (SQLException e) {
							printSQLException (e);
						}
						return sortStock;
						
					}
				
					//select tout le produit 
					
					public List<SortStock> selectAllSort() {
						List<SortStock> sortStock=new ArrayList<>();
						try (Connection connection = getConnection();
								PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ALL_SORT) ){
							System.out.println(prepareStatement);
							ResultSet rs = prepareStatement.executeQuery();							
							while (rs.next()) {
								int id_sort =rs.getInt("id_sort");
								String nom_pers =rs.getString("nom_pers");
								String nom_prodt =rs.getString("nom_prodt");
								int quantiter =rs.getInt("quantiter");
								String date_sort =rs.getString("date_sort");								
								sortStock.add(new SortStock (id_sort,nom_pers,nom_prodt,quantiter,date_sort));
							}
							
						} catch (SQLException e) {
							printSQLException (e);
						}
						return sortStock; 
						
					}	
					
					
					
					//create update sort 
					public boolean updateSort(SortStock sortStock ) throws SQLException{
						boolean rowUpdate;
						try( Connection connection = getConnection();
								PreparedStatement statement =connection.prepareStatement(UPDATE_SORT_SQL)){
							System.out.println("update SortStock" +statement);
							statement.setString(1, sortStock.getNom_pers());
							statement.setString(2, sortStock.getNom_prodt());
							statement.setInt(3, sortStock.getQuantiter());
							statement.setString(4, sortStock.getDate_sort());
							statement.setInt(5, sortStock.getId_sort());
							System.out.println(statement);
							rowUpdate=statement.executeUpdate() > 0;	
						}
						return rowUpdate;
					}
					
					//Delete sort stock
					public boolean deleteSort(int id_sort)throws SQLException{
						boolean rowDeleted;
						try (Connection connection =getConnection();
								PreparedStatement statement = connection.prepareStatement(DELETE_SORT_SQL)){
							statement.setInt(1, id_sort);
							rowDeleted = statement.executeUpdate()>0;
						}
						return rowDeleted;
					}
	
	
					
					//select all admin of the login
					
					public List<Admin> selectAllAdmin(String log, String password) {
						List<Admin> admin=new ArrayList<>();
						try (Connection connection = getConnection();
								PreparedStatement prepareStatement = connection.prepareStatement(SELECT_ADMIN) ){
							prepareStatement.setString(1 ,log);
							prepareStatement.setString(2 ,password);
							System.out.println(prepareStatement);
							ResultSet rs = prepareStatement.executeQuery();							
							while (rs.next()) {
								String email =rs.getString("email");
								String motPasse =rs.getString("motPasse");								
								admin.add(new Admin (email,motPasse ));
							}
							
						} catch (SQLException e) {
							printSQLException (e);
						}
						return admin; 
						
					}
	
	
	
	
	
	private void printSQLException(SQLException ex) {
		
		for( Throwable e:ex) {
			if(e instanceof SQLException ) {
				e.printStackTrace(System.err);
				System.err.println("SQLState" + ((SQLException ) e).getSQLState());
				System.err.println("Error Code" + ((SQLException ) e).getErrorCode());
				System.err.println("SQLState" + e.getMessage());
				Throwable t=ex.getCause();
				while(t != null) {
					System.out.println("Cause :" + t);
					t =t.getCause();
				}
			}
		}
	}

	
	
	


	
	
}
