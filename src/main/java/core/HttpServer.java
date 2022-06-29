package core;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer 
{
    public HttpServer(String[] args) {
    }

    public static void main( String[] args ) throws IOException
    {
        int port = 8080;
        if (args.length > 0)
            port = Integer.parseInt(args[0]);

        // Create a thread pool
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // Create the server
        ServerSocket server = new ServerSocket(port);
        System.out.printf("Starting the server on port %d\n", port);

        while (true) {
            // Wait for incoming connection
            System.out.println("Waiting for client connection");
            Socket sock = server.accept();
            System.out.println("Connected...");
            HttpClientConnection thr = new HttpClientConnection(sock);
            threadPool.submit(thr);
            System.out.println("Submitted to threadpool");
        }

        Socket sock;
        OutputStream clientOutput = sock.getOutputStream();
            clientOutput.write("HTTP/1.1 200 OK\r\n".getBytes());
            clientOutput.write("\r\n".getBytes());
            clientOutput.write("HTTP/1.1 404 Not Found\r\n".getBytes());
            clientOutput.write("\r\n".getBytes());
            clientOutput.write("HTTP/1.1 405 Method Not Allowed\r\n".getBytes());
            clientOutput.write("\r\n".getBytes());
            clientOutput.flush();
            System.err.println("Client connection closed!");
            in.close();
            clientOutput.close();

        
    }
}
