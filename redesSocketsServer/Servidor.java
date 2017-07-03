import java.io.* ;
import java.net.* ;
class Servidor {
  static final int PUERTO=1234;
  public Servidor( ) {
    try {
      ServerSocket skServidor = new ServerSocket( PUERTO );
      System.out.println("Escucho el puerto " + PUERTO );
      for ( int numCli = 0; numCli < 3; numCli++ ) {
        Socket skCliente = skServidor.accept(); // Crea objeto
        System.out.println("Sirvo al cliente " + numCli);
        
        DataInputStream in = new DataInputStream(skCliente.getInputStream());
        DataOutputStream out = new DataOutputStream(skCliente.getOutputStream());
        
        int x = in.readInt();
        int y = in.readInt();
        
        int result = x+y;
        out.writeInt(result);
        
        skCliente.close();
      } 
      System.out.println("Demasiados clientes por hoy");
    } catch( Exception e ) {
      System.out.println( e.getMessage() );
    }
  }
  public static void main( String[] arg ) {
    new Servidor();
  }
}
