// import statements
import com.opencsv.CSVWriter;
import java.io.FileWriter;

public class IQHistory{

    private int iPort;
    private IQSocket historySocket;

    public IQHistory(int iPort){
        this.iPort = iPort;
    }

    // set variable states before executing
    public void prepare(){
        this.historySocket.Connect(this.iPort);
        //TODO: logging
        System.out.println("Connection status : " + this.historySocket.isConnected());
        this.historySocket.CreateBuffers();
        try {
            // set protocol for data request
            this.historySocket.writer.write(setProtocol("1.0"));
        } catch (Exception e){
            // TODO: logging
            e.printStackTrace();
        }
    }

    // execute
    public void run(){
        try {
            this.prepare();
            // listen on the socket for data
            HistoryListener listener = new HistoryListener();
            // request tick days on symbol
            this.requestData(this.HTD("@ES#", "1000"));
            // TODO: implement processor
            listener.run("/csv");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void requestData(String request){
        try {
            this.historySocket.writer.write(request);
        } catch (Exception e){
            // TODO: logging
            e.printStackTrace();
        }
    }

    // set protocol using a separate string
    public String setProtocol(String version){
        return String.format("S,SET PROTOCOL, %s\r\n", version);
    }

    // set client name for IQ connection
    public String setClientName(String name){
        return String.format("S,SET CLIENT NAME, %s\r\n", name);
    }


    // tick / max pts.
    public String HTX(String symbol, String maxPts){
        return String.format("HTX,%s,%s\r\n", symbol, maxPts);
    }

    // tick / max days
    public String HTD(String symbol, String maxDays){
        return String.format("HTD,%s,%s\r\n", symbol, maxDays);
    }

    // TODO: look up specifics for timeframe formatting

    // tick / timeframe
    // time format - CCYYMMDD HHmmSS
    public String HTT(String symbol, String begin, String end){
        return String.format("HTT,%s,%s,%s\r\n", symbol, begin, end);
    }

    // interval by seconds / max pts.
    public String HIX(String symbol, String interval, String maxData){
        return String.format("HIX,%s,%s,%s\r\n", symbol, interval, maxData);
    }

    // interval by seconds / max days
    public String HID(String symbol, String interval, String maxDays){
        return String.format("HID,%s,%s,%s\r\n", symbol, interval, maxDays);
    }

    // interval, timeframe (begin, end)
    public String HIT(String symbol, String interval, String begin, String end){
        return String.format("HID,%s,%s,%s,%s\r\n", symbol, interval, begin,end);
    }

    // daily, max days
    public String HDX(String symbol, String maxDays){
        return String.format("HID,%s,%s\r\n", symbol, maxDays);
    }

    public String HDT(String symbol, String begin, String end){
        return String.format("HID,%s,%s,%s\r\n", symbol, begin, end);
    }
    public String HWX(String symbol, String maxWeeks){
        return String.format("HID,%s,%s\r\n", symbol, maxWeeks);
    }
    public String HMX(String symbol, String maxMonths){
        return String.format("HID,%s,%s\r\n", symbol, maxMonths);
    }

    class HistoryListener extends Thread {
        public void run(String outputPath){
            String line;
            try{
                CSVWriter writer = new CSVWriter(new FileWriter(outputPath));
                while((line = historySocket.reader.readLine()) != null){
                    line = historySocket.reader.readLine();
                    System.out.println(line);
                    // TODO: this smells
                    writer.writeNext(historySocket.reader.readLine().split(","));
                }
                writer.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

