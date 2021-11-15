package blogProject.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import blogProject.menu.Port;

public class Client implements Runnable {

	public void run() {
		try {

			String receiveMessage = ""; // mesaj almak icin
			String sendMessage = ""; // mesaj gondermek

			// port acmak icin yapiyoruz
			Socket socket = new Socket("localhost", Port.PORT);

			// client veri gonderecek
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);

			// serverdan gelen veriyi okuma
			InputStream inputStream = socket.getInputStream();
			BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));

			System.out.println("Lütfen mesaj yazınız.");

			while (!sendMessage.equals("0")) {
				// clienttan veri alimi
				sendMessage = bufferedReader.readLine();
				printWriter.println(sendMessage);
				printWriter.flush(); // tazelenmek

				if ((receiveMessage = bufferedReader2.readLine()) != null) {
					System.out.println((LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
							+ " Admin: " + receiveMessage);

				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}
	}
}
