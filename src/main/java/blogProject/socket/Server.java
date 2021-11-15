package blogProject.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import blogProject.menu.Port;

public class Server implements Runnable {

	@Override
	public void run() {
		try {

			String receiveMessage = "";
			String sendMessage = "";

			ServerSocket serverSocket = new ServerSocket(Port.PORT);
			System.out.println("Chat Aplikasyonu Hazır!");

			Socket socket = serverSocket.accept();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			OutputStream outputStream = socket.getOutputStream();

			PrintWriter printWriter = new PrintWriter(outputStream, true);

			InputStream inputStream = socket.getInputStream();
			BufferedReader receiveRead = new BufferedReader(new InputStreamReader(inputStream));

			while (!sendMessage.equals("0")) {
				if ((receiveMessage = receiveRead.readLine()) != null) {
					System.out.println((LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
							+ " User : " + receiveMessage);

					// TO DO nickname nasil kullanicidan alip buraya koyabilirim???
				}

				sendMessage = bufferedReader.readLine();
				printWriter.println(sendMessage);
				printWriter.flush();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
