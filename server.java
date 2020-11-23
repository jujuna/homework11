import java.io.IOException;
import java.net.ServerSocket;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;
import java.io.ObjectInputStream;



public class server extends Thread {
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream inp_stream;
    String text;

    public void run(){
        
        try{
            ServerSocket serv_socket=new ServerSocket(8080);
            while (true){
                socket = serv_socket.accept();
                inp_stream = new ObjectInputStream(socket.getInputStream());
                Object in = inp_stream.readObject();
                System.out.println("Client: " + in);
                Scanner scanner = new Scanner(System.in);
                text = scanner.nextLine();
                out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(text);
            } 
            
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
