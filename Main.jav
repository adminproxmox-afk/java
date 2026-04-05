import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Backend started");

        while(true){

            Socket socket = server.accept();

            BufferedReader in =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line;
            while(!(line = in.readLine()).isEmpty()){}

            BufferedWriter out =
                new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            out.write("HTTP/1.1 200 OK\r\n");
            out.write("Content-Type: application/json\r\n\r\n");

            out.write("{\"message\":\"Hello from Java backend\"}");

            out.flush();
            socket.close();
        }
    }
}
