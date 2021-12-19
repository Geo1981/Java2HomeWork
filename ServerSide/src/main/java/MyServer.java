import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    private final Integer SERVER_PORT = 8080;
    Socket socket = null;


    public MyServer() {
        System.out.println("Сервер запущен.");
        startServer();
    }

    private void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился.");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Scanner serverWrite = new Scanner(System.in);
            new Thread(() -> {
                while (serverWrite.hasNext()) {
                    final String serverStr = serverWrite.nextLine();
                    try {
                        dos.writeUTF("Сервер: " + serverStr);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            while (true) {
                String str = dis.readUTF();
                System.out.println("Клиент: " + str);
                if (str.equalsIgnoreCase("/close")) {
                    dos.writeUTF(str);
                    System.out.println("Клиент отключился");
                    closeConnection(dis, dos);
                    break;
                }
                dos.writeUTF("Клиент: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection(DataInputStream dis, DataOutputStream dos) {
        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
