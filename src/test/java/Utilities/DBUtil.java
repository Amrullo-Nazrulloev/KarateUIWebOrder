package Utilities;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBUtil {
    private JdbcTemplate jdbc;
    private Connection connection = null;
    DriverManagerDataSource dataSource;

    public Connection getConnection() {
        return connection;}

    public DBUtil(Map<String,Object> config){
        try{
            if (this.connection == null){
                String url = (String) config.get("url");
                String username = (String) config.get("username");
                String password = (String) config.get("password");
                String driver = (String) config.get("driverClassName");
                dataSource = new DriverManagerDataSource(driver);
                dataSource.setDriverClassName(driver);
                dataSource.setUrl(url+"?zeroDateTimeBehaviour=convertToNull");
                dataSource.setUsername(username);
                dataSource.setPassword(password);
                jdbc= new JdbcTemplate(dataSource);
                this.connection = this.jdbc.getDataSource().getConnection();
                System.out.println("Connection created successfully");
            }else {
                this.connection = this.getConnection();
                System.out.println("Connection already exist");
            }
        }catch (SQLException var2){
            System.out.println("\nSQLExeption while accessing the database:{}"+var2.getMessage());
        }catch (Exception var3){
            System.out.println("\nConnection could not be created:{}"+var3.getMessage());
        }
    }

    public Map<String,Object> redRow(String query){return jdbc.queryForMap(query);}

    public List<Map<String,Object>> redRows(String query){
        return jdbc.queryForList(query);
    }

    public int update(String sql){
        return jdbc.update(sql);
    }

    public void closeConnection(){

        try {
            if (this.connection != null){
                this.connection.close();
                System.out.println("Connection closed successfully");
            }
        }catch (SQLException var6){
            System.out.println("\nSQLExeption while accessing the database:{}"+var6.getMessage());
        }catch (Exception var7){
            System.out.println("\nConnection cold not be closed:{}"+var7.getMessage());
        }finally {
            this.connection = null;
        }
    }







}


