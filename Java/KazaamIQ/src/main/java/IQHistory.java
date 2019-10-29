
public class IQHistory{

    private int iPort;
    private IQSocket historySocket;

    public IQHistory(int iPort){
        this.iPort = iPort;
    }

    public void prepare(){
        this.historySocket.ConnectSocket(this.iPort);
        System.out.println("Connection status : " + this.historySocket.isConnected());
        this.historySocket.CreateBuffers();
        try {
            this.historySocket.writer.write(setProtocol("1.0"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void requestData(String request){
        try {

        }
    }

    public String setProtocol(String version){
        return String.format("S,SET PROTOCOL, %s\r\n", version);
    }

    public String setClientName(String name){
        return String.format("S,SET CLIENT NAME, %s\r\n", name);
    }

    public String HTX(String symbol, String maxPts){
        return String.format("HTX,%s,%s\r\n", symbol, maxPts);
    }
    public String HTD(String symbol, String maxDays){
        return String.format("HTD,%s,%s\r\n", symbol, maxDays);
    }
    public String HTT(String symbol, String begin, String end){
        return String.format("HTT,%s,%s,%s\r\n", symbol, begin, end);
    }
    public String HIX(String symbol, String interval, String maxData){
        return String.format("HIX,%s,%s,%s\r\n", symbol, interval, maxData);
    }
    public String HID(String symbol, String interval, String maxDays){
        return String.format("HID,%s,%s,%s\r\n", symbol, interval, maxDays);
    }
    public String HIT(String symbol, String interval, String begin, String end){
        return String.format("HID,%s,%s,%s,%s\r\n", symbol, interval, begin,end);
    }
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
        public void run(){
            String line;
            try{
                while((line = historySocket.reader.readLine()) != null){

                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

