import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer extends PlayerHandler{
    private ServerSocket serverSocket; // accepts incoming connections 

    public GameServer(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    // start game server
    public void startServer(){
        System.out.println("Game Server Running...");
        try{
            while(!maximumPlayers(playerHandler.size())){ // server socket will close when a maximum of ten clients have connected
                Socket socket = serverSocket.accept();

                System.out.println("A new player has joined the game."); 

                PlayerHandler playerHandler = new PlayerHandler(socket);

                Thread thread = new Thread(playerHandler);
                thread.start();
            }
        } catch (IOException e){
            closeServerSocket();
        }
    }

    // closes server
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

    public boolean maximumPlayers(int playerCount){
        if(playerCount >= 2){
            System.out.println("Maximum players reached.");
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(1234);
        GameServer server = new GameServer(serverSocket);
        server.startServer();
    }
}
