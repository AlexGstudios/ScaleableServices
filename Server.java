import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {

    boolean isTrue = true;

    @Override
    public void run() {

        ServerSocket ss;
        try {

            ss = new ServerSocket(60010);
            while (isTrue) {

                Socket socket = ss.accept();
                System.out.println("Server has found a connection.");

                OutputStream output = socket.getOutputStream();

                InputStream input = socket.getInputStream();

                byte[] buffer = new byte[256];
                int count = input.read(buffer);
                String toWrite = new String(buffer, 0, count);
                System.out.println("This is from the server: " + toWrite);

                byte[] toSend = toWrite.getBytes();
                output.write(toSend);
                output.flush();

                socket.close();
            }
            ss.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}