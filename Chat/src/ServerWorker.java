import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class ServerWorker extends Thread { // create thread everytime got conn from client

	private final Socket clientSocket;

	public ServerWorker(Socket clientSocket) {
		this.clientSocket=clientSocket;
	}
	@Override
	public void run() {
		try {
			handleClientSocket();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void handleClientSocket() throws IOException, InterruptedException {
		InputStream inputStream= clientSocket.getInputStream(); // communication with client conn
		OutputStream outputStream = clientSocket.getOutputStream();
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while((line= reader.readLine()) !=null) {
			if("quit".equalsIgnoreCase(line)) {
				break;
			}
			String msg = "You typed: " + line + "\n";
			outputStream.write(msg.getBytes()); // echo back
		}
		clientSocket.close();
	} // multiptle connection- established clients
}
