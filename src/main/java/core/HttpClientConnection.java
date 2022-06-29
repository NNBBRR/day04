package core;

import java.io.IOException;
import java.net.Socket;

public class HttpClientConnection implements Runnable {

    public HttpClientConnection(Socket s) {
        
    }

    @Override
    public void run() {
        // run() is the thread's body
        System.out.println("Starting client thread");
        try {
            Socket sock;
            NetworkIO netIO = new NetworkIO(sock);
            String req = "";
            //req is request from the client to the server

            while (!req.equals("exit")) {
                try {
                    req = netIO.read();
                    System.out.printf("[client] %s\n", req);
                    if (req.trim().equals("exit"))
                        break; // break out from the closest loop
                    netIO.write(req.toUpperCase());
                } catch (IOException ex) {
                    // exit when there is a network connection
                    break; // break out from the closest loop
                }
            }

            netIO.close();
            sock.close();
            System.out.println("Exiting thread");
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
