import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class GameServer {
    private ServerSocket serverSocket; // accepts incoming up to two incoming connections

    public GameServer(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    // start game server
    public void startServer(){
        try{
            while(!serverSocket.isClosed()){ // server socket will close when a maximum of ten clients have connected
                Socket socket = serverSocket.accept();
                System.out.println("A new player has connected");
                // PlayerHandler playerHandler = new PlayerHandler(socket);
            }
        } catch (IOException e){

        }
    }

    // handles closing server conditions
    public void closeServerSocket(){
        try{
            if(serverSocket != null){ // ensure server socket is not null
                serverSocket.close();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
