
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;

public class Server {
	private static ServerSocket serverSocket;

	public static void main(String[] args) {
		int port= 8813;
		try {
			serverSocket = new ServerSocket(port);
			while(true) {
			Socket clientSocket=serverSocket.accept();// create connection i.e. client and sever
			OutputStream outputStream= clientSocket.getOutputStream();
			outputStream.write("Hello World\n".getBytes());
			clientSocket.close();
			}
			// turn into socket represents connection to the client
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
