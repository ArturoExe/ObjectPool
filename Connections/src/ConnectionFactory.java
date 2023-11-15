/// Paquete que administra el object pool de las conexiones
import com.mchange.v2.c3p0.ComboPooledDataSource;
///Paquetes para realizar conexion en sql
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class ConnectionFactory {

  private DataSource dataSource;

  public ConnectionFactory() {
    var comboPooledDataSource = new ComboPooledDataSource();
    comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/world");
    comboPooledDataSource.setUser("root");
    comboPooledDataSource.setPassword("password");
    comboPooledDataSource.setMaxPoolSize(10); /// Limita la cantidad de objetos

    this.dataSource = comboPooledDataSource;
  }

  public Connection recuperaConexion() {
    try {
      return this.dataSource.getConnection();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void liberaConexion(Connection connection) {
    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
