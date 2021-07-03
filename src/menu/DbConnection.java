package menu;

import java.sql.*;

public class DbConnection {
    String url = "jdbc:mysql://localhost:3306/proiectjava";
    String user = "root";
    String password = "Bobolelo2";
    Connection myConn = DriverManager.getConnection(url, user, password);
    Statement mySt = myConn.createStatement();

    public DbConnection() throws SQLException {
        ;
    }

    public ResultSet select_database(String sql_query) throws SQLException {
        String sql=sql_query;
        ResultSet rs = mySt.executeQuery(sql);

        return rs;
    }

    public void update_database(String sql_query) throws SQLException {
        String sql;
        sql=sql_query;
        int rs2 = mySt.executeUpdate(sql);

    }
}
