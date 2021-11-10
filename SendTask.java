import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendTask implements Runnable {

    boolean isTrue = true;
    Scanner sc = new Scanner(System.in);

    @Override
    public void run() {
        try {
            while (isTrue) {
                Socket socket = new Socket("localhost", 60010);

                OutputStream output = socket.getOutputStream();

                InputStream input = socket.getInputStream();

                String toSend = sc.nextLine();
                output.write(toSend.getBytes());
                output.flush();

                byte[] toWrite = input.readAllBytes();
                System.out.println("This is the client talking: " + new String(toWrite));

                socket.close();
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}