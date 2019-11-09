import java.io.*;
import java.net.*;

public class IQSocket extends Socket {
    // class variables
    BufferedReader reader;
    BufferedWriter writer;

    public IQSocket(){
        super();
    }

    // takes a port and establishes a connection
    protected boolean Connect(int iPort){
        try{
            this.connect(new InetSocketAddress("localhost", iPort));
        } catch (Exception e){
            System.out.println("Unable to connect");
            e.printStackTrace();
        } finally {
            return this.isConnected();
        }
    }

    protected void Disconnect(){
        try {
            this.CloseBuffers();
            this.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void CreateBuffers(){
        try {
            reader = new BufferedReader(new InputStreamReader(this.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(this.getOutputStream()));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Unable to create buffers");
        }
    }

    protected void CloseBuffers(){
        try {
            reader.close();
            writer.close();
        } catch (Exception e){
            System.out.println("Unable to close buffers");
            e.printStackTrace();
        }
    }
}
