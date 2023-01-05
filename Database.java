import java.sql.*;
import java.util.Date;

public class Database {

  private Connection connection;
  private Statement statement;
  private int PORT = 3306;
  private String USER = "root";
  private String PASSWORD = "256841";
  private String DB = "ihm";
  private String TABLE = "medicine";
  private String HOST = "localhost";
  private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB;

  public Database() {

    try {
    
    connection = DriverManager.getConnection(URL, USER, PASSWORD);
    statement = connection.createStatement();

    // check if table exist otherwise create one
    createTable();

    } catch (SQLException e) {
      e.printStackTrace();
    }


  }

  public boolean insert(Medicine med) {

    try {
      String sql = "INSERT INTO " + TABLE + " VALUES('" +
                   med.getCode() + "', '" +
                   med.getName() + "', " +
                   med.getPrice() + ", " +
                   med.getQuantity() + ", '" +
                   med.getDate() + "')";
      
      statement.executeUpdate(sql);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean update(Medicine med) {
    try {
      String sql = "UPDATE " + TABLE +
                   " SET name = '" + med.getName() + "', " +
                   " price = " + med.getPrice() + ", " +
                   " quantity = " + med.getQuantity() + ", " +
                   " date = '" + med.getDate() + "' " +
                   " WHERE code = '" + med.getCode() + "';";

      return statement.executeUpdate(sql) > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
  }

  public boolean delete(String code) {
    try {
      String sql = "DELETE FROM " + TABLE +
                   " WHERE code = " + code;
      return statement.executeUpdate(sql) > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public Medicine[] queryAll() {
    
    try {
      String sql = "SELECT count(*) FROM " + TABLE;
      ResultSet resultSet = statement.executeQuery(sql);
      resultSet.next();
      Medicine[] medList = new Medicine[resultSet.getInt(1)];
      
      sql = "SELECT * FROM " + TABLE;
      resultSet = statement.executeQuery(sql);
      int index = 0;
      while (resultSet.next()) {

        String _code = resultSet.getString(1);
        String name = resultSet.getString(2);
        double price = resultSet.getDouble(3);
        int quantity = resultSet.getInt(4);
        String date = resultSet.getString(5);

        medList[index] = new Medicine(_code, name, price, quantity, date);

        index++;
      }
      return medList;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public Medicine[] queryByCode(String code) {

    try {
      String sql = "SELECT * FROM " + TABLE +
                   " WHERE code='" + code + "'";
      ResultSet resultSet = statement.executeQuery(sql);

      while (resultSet.next()) {
        Medicine[] data = new Medicine[1];
        String _code = resultSet.getString(1);
        String name = resultSet.getString(2);
        double price = resultSet.getDouble(3);
        int quantity = resultSet.getInt(4);
        String date = resultSet.getString(5);

        data[0] = new Medicine(_code, name, price, quantity, date);
        return data;
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
      }
    return null;
  }

  public boolean createTable() {

    try {
      if (!tableExists()) {

        String sql = "CREATE TABLE `" + DB + "`.`" + TABLE + "` " +
        "( `code` VARCHAR(30) NOT NULL ," +
        "`name` VARCHAR(255) NOT NULL ," +
        "`price` DOUBLE NOT NULL ," +
        "`quantity` INT NOT NULL ," +
        "`date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ," +
        "PRIMARY KEY (`code`)) ENGINE = InnoDB;";

        statement.executeUpdate(sql);
        System.out.println("Table " + TABLE + " is created");
      }
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean tableExists() throws SQLException {

    PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) "
        + "FROM information_schema.tables "
        + "WHERE table_name = ?"
        + "LIMIT 1;");
    preparedStatement.setString(1, TABLE);

    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();
    return resultSet.getInt(1) > 0;
  }

  public static void main(String[] args) throws Exception {
    // Database db = new Database();
    // Medicine med = new Medicine("12345", "test", 99.99, 99);
    // db.insert(med);
    // System.out.println(db.delete("12345"));
    
    
  }

}











