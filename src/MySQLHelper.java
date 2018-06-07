import java.sql.*;

public class MySQLHelper {

    private static String driver = "com.mysql.jdbc.Driver"; // 驱动器
    private String url;  // "jdbc:mysql://ip:port/db"
    private String user;
    private String passwd;
    private Connection conn;

    public MySQLHelper(String url,String user,String passwd)
    {
        this.url =  url;
        this.user = user;
        this.passwd = passwd;
        conn = DoConn();
    }

    private Connection DoConn()
    {
        Connection conn1 = null;
        try{
            // 加载驱动器
            Class.forName(driver);
            // 连接数据库
            conn1 = DriverManager.getConnection(url,user,passwd);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn1;
    }

    public ResultSet DoSelect(String sql) throws SQLException{
        // 执行查询
        Statement st = conn.createStatement();
        return st.executeQuery(sql);
    }

    public boolean DoChange(String sql){
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            int res = ps.executeUpdate();
            if (res > 0)
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("准备关闭句柄...");
        if(conn!=null)
            conn.close();
        super.finalize();
    }
}
