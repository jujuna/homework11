import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.net.Socket;
import java.net.InetAddress;


public class client extends Thread {
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String text;


    public void run(){
        try{
            while (true){
            socket = new Socket(InetAddress.getByName("localhost"), 8080);
            Scanner scanner = new Scanner(System.in);
            text = scanner.nextLine();
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(text);
            in = new ObjectInputStream(socket.getInputStream());
            Object read = in.readObject();
            System.out.println("Server: " + read);
            }
            
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

