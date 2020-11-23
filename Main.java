public class Main {
     public static void main(String[] args) {
        client cl=new client();
        server ser=new server();
        cl.start();
        ser.start();
    }
}
