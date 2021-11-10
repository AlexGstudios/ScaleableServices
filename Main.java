public class Main {

    public static void main(String[] args) {

        server();
        client();
    }

    public static void client() {

        SendTask st = new SendTask();
        Thread thread = new Thread(st);

        thread.start();
    }

    public static void server() {

        Server server = new Server();
        Thread serverThread = new Thread(server);

        serverThread.start();
    }
}