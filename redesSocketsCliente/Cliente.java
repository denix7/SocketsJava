import java.io.*;
import java.net.*;
import java.util.Scanner;
class Cliente {
  static final String HOST = "127.0.0.1";
  static final int PUERTO=1234;
  public Cliente( ) {
    try{
      Socket skCliente = new Socket( HOST , PUERTO );
      
      InputStream aux = skCliente.getInputStream();
      DataInputStream in = new DataInputStream(skCliente.getInputStream());
      DataOutputStream out = new DataOutputStream (skCliente.getOutputStream());
      
      Scanner param = new Scanner(System.in);
      
      System.out.println("Ingrese primer operando");
      int x = param.nextInt();
      
      System.out.println("Ingrese el segundo operando");
      int y = param.nextInt();
      
      out.writeInt(x);
      out.writeInt(y);
      
      System.out.println(in.readInt());
      skCliente.close();
    } catch( Exception e ) {
      System.out.println( e.getMessage() );
    }
  }
  public static void main( String[] arg ) {
    new Cliente();
  }
}
