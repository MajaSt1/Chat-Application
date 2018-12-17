
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.Date;

public class Server {
	private static ServerSocket serverSocket;

	public static void main(String[] args) {
		int port = 8813;
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				System.out.println("About to accept client connection...");
				Socket clientSocket = serverSocket.accept();// create connection i.e. client and sever
				System.out.println("Accepted connection from " + clientSocket);
				ServerWorker worker = new ServerWorker(clientSocket);
				worker.start();

				// turn into socket represents connection to the client
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
