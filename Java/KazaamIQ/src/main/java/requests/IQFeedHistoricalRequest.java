package requests;

public class IQFeedHistoricalRequest {

    // TODO: refactor add validation

    // request strings for IQFeed interface
    // In general: timeframes are specified in the following format: CCYYMMDD HHmmSS
    // see here http://www.iqfeed.net/dev/api/docs/HistoricalviaTCPIP.cfm for more information
    // tick / max pts
    // required
    private String symbol;
    private String requestType;
    // optional
    private String beginDate;
    private String beginDateTime;
    private String beginFilterTime;
    private String dataDirection;
    private String dataPtsPerSend;
    private String endDate;
    private String endDateTime;
    private String endFilterTime;
    private String includePartialData;
    private String interval;
    private String intervalType;
    private String labelAtBeginning;
    private String maxDataPts;
    private String maxDays;
    private String maxMonths;
    private String maxWeeks;
    private String requestID;

    public IQFeedHistoricalRequest(IQFeedHistoricalRequestBuilder builder) {
        symbol = builder.symbol;
        requestType = builder.requestType;
        beginDate = builder.beginDate;
        beginDateTime = builder.beginDateTime;
        beginFilterTime = builder.beginFilterTime;
        dataDirection = builder.dataDirection;
        dataPtsPerSend = builder.dataPtsPerSend;
        endDate = builder.endDate;
        endDateTime = builder.endDateTime;
        endFilterTime = builder.endFilterTime;
        includePartialData = builder.includePartialData;
        interval= builder.interval;
        intervalType = builder.intervalType;
        labelAtBeginning = builder.labelAtBeginning;
        maxDataPts = builder.maxDataPts;
        maxDays = builder.maxDays;
        maxMonths = builder.maxMonths;
        maxWeeks = builder.maxWeeks;
        requestID = builder.requestID;
    }
}

//    public String HTX(String symbol, String maxPts){
//        return String.format("HTX,%s,%s\r\n", symbol, maxPts);
//    }
//
//    // tick / max days
//    public String HTD(String symbol, String maxDays){ return String.format("HTD,%s,%s\r\n", symbol, maxDays); }
//
//    // TODO: look up specifics for timeframe formatting
//
//    // tick / timeframe
//    // time format - CCYYMMDD HHmmSS
//    public String HTT(String symbol, String begin, String end){ return String.format("HTT,%s,%s,%s\r\n", symbol, begin, end); }
//
//    // interval by seconds / max pts.
//    public String HIX(String symbol, String interval, String maxData){ return String.format("HIX,%s,%s,%s\r\n", symbol, interval, maxData); }
//
//    // interval by seconds / max days
//    public String HID(String symbol, String interval, String maxDays){ return String.format("HID,%s,%s,%s\r\n", symbol, interval, maxDays); }
//
//    // interval, timeframe (begin, end)
//    public String HIT(String symbol, String interval, String begin, String end){ return String.format("HID,%s,%s,%s,%s\r\n", symbol, interval, begin,end); }
//
//    // daily, max days
//    public String HDX(String symbol, String maxDays){
//        return String.format("HID,%s,%s\r\n", symbol, maxDays);
//    }
//
//    public String HDT(String symbol, String begin, String end){ return String.format("HID,%s,%s,%s\r\n", symbol, begin, end); }
//
//    public String HWX(String symbol, String maxWeeks){
//        return String.format("HID,%s,%s\r\n", symbol, maxWeeks);
//    }
//
//    public String HMX(String symbol, String maxMonths){ return String.format("HID,%s,%s\r\n", symbol, maxMonths); }
//    // tick / max pts.
//    public String HTX(String symbol, String maxPts){
//        return String.format("HTX,%s,%s\r\n", symbol, maxPts);
//    }
//
//    // tick / max days
//    public String HTD(String symbol, String maxDays){ return String.format("HTD,%s,%s\r\n", symbol, maxDays); }
//
//    // TODO: look up specifics for timeframe formatting
//
//    // tick / timeframe
//    // time format - CCYYMMDD HHmmSS
//    public String HTT(String symbol, String begin, String end){ return String.format("HTT,%s,%s,%s\r\n", symbol, begin, end); }
//
//    // interval by seconds / max pts.
//    public String HIX(String symbol, String interval, String maxData){ return String.format("HIX,%s,%s,%s\r\n", symbol, interval, maxData); }
//
//    // interval by seconds / max days
//    public String HID(String symbol, String interval, String maxDays){ return String.format("HID,%s,%s,%s\r\n", symbol, interval, maxDays); }
//
//    // interval, timeframe (begin, end)
//    public String HIT(String symbol, String interval, String begin, String end){ return String.format("HID,%s,%s,%s,%s\r\n", symbol, interval, begin,end); }
//
//    // daily, max days
//    public String HDX(String symbol, String maxDays){
//        return String.format("HID,%s,%s\r\n", symbol, maxDays);
//    }
//
//    public String HDT(String symbol, String begin, String end){ return String.format("HID,%s,%s,%s\r\n", symbol, begin, end); }
//    public String HWX(String symbol, String maxWeeks){
//        return String.format("HID,%s,%s\r\n", symbol, maxWeeks);
//    }
//    public String HMX(String symbol, String maxMonths){ return String.format("HID,%s,%s\r\n", symbol, maxMonths); }
