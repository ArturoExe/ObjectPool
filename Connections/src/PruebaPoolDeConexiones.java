import java.sql.Connection;
import java.sql.SQLException;

public class PruebaPoolDeConexiones {

  public static void main(String[] args) throws SQLException {
    ConnectionFactory factory = new ConnectionFactory();

    for (int i = 0; i < 20; i++) {
      Connection connection = factory.recuperaConexion();
      System.out.println("\n" + "Abriendo conexión #" + i);

      ///Comentar linea para probar que el object pool solo permite 10 conexiones abiertas
      factory.liberaConexion(connection);
      System.out.println("Cerrando conexión #" + i + "\n");
    }
  }
}
