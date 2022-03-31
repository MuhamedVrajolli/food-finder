package foodfinder.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

public class DataSource {
   public static Connection getConnection(){
       Connection connection = null;
       Properties properties = new PropertiesLoader().load();
       try {
           connection = DriverManager.getConnection(
                   properties.getProperty("datasource.url"), 
                   properties.getProperty("datasource.username"), 
                   properties.getProperty("datasource.password")
           );
       } catch (Exception e) {
           e.printStackTrace();
           System.exit(0);
       }
       return connection;
   }
   
   public static DSLContext getContext(){
       Settings settings = new Settings();
        DSLContext using = DSL.using(getConnection(), SQLDialect.POSTGRES, settings);
        return using;
   }
}
