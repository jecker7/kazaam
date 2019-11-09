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


    public IQFeedHistoricalRequest(String symbol, String ){
    }

    public static class IQFeedHistoricalRequestBuilder {

        // TODO: Validators
        public IQFeedHistoricalRequestBuilder setSymbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setRequestType(String requestType) {
            this.requestType = requestType;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setBeginDate(String beginDate) {
            this.beginDate = beginDate;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setBeginDateTime(String beginDateTime) {
            this.beginDateTime = beginDateTime;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setBeginFilterTime(String beginFilterTime) {
            this.beginFilterTime = beginFilterTime;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setDataDirection(String dataDirection) {
            this.dataDirection = dataDirection;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setDataPtsPerSend(String dataPtsPerSend) {
            this.dataPtsPerSend = dataPtsPerSend;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setEndDateTime(String endDateTime) {
            this.endDateTime = endDateTime;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setEndFilterTime(String endFilterTime) {
            this.endFilterTime = endFilterTime;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setIncludePartialData(String includePartialData) {
            this.includePartialData = includePartialData;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setInterval(String interval) {
            this.interval = interval;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setIntervalType(String intervalType) {
            this.intervalType = intervalType;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setLabelAtBeginning(String labelAtBeginning) {
            this.labelAtBeginning = labelAtBeginning;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setMaxDataPts(String maxDataPts) {
            this.maxDataPts = maxDataPts;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setMaxDays(String maxDays) {
            this.maxDays = maxDays;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setMaxMonths(String maxMonths) {
            this.maxMonths = maxMonths;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setMaxWeeks(String maxWeeks) {
            this.maxWeeks = maxWeeks;
            return this;
        }

        public IQFeedHistoricalRequestBuilder setRequestID(String requestID) {
            this.requestID = requestID;
            return this;
        }

        // required fields
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

        public RequestBulider(String symbol, String requestType) {
            this.symbol = symbol;
            this.requestType = requestType;
        }

        public RequestBuilder setAddress(){

        }

    }




    public String HTX(String symbol, String maxPts){
        return String.format("HTX,%s,%s\r\n", symbol, maxPts);
    }

    // tick / max days
    public String HTD(String symbol, String maxDays){ return String.format("HTD,%s,%s\r\n", symbol, maxDays); }

    // TODO: look up specifics for timeframe formatting

    // tick / timeframe
    // time format - CCYYMMDD HHmmSS
    public String HTT(String symbol, String begin, String end){ return String.format("HTT,%s,%s,%s\r\n", symbol, begin, end); }

    // interval by seconds / max pts.
    public String HIX(String symbol, String interval, String maxData){ return String.format("HIX,%s,%s,%s\r\n", symbol, interval, maxData); }

    // interval by seconds / max days
    public String HID(String symbol, String interval, String maxDays){ return String.format("HID,%s,%s,%s\r\n", symbol, interval, maxDays); }

    // interval, timeframe (begin, end)
    public String HIT(String symbol, String interval, String begin, String end){ return String.format("HID,%s,%s,%s,%s\r\n", symbol, interval, begin,end); }

    // daily, max days
    public String HDX(String symbol, String maxDays){
        return String.format("HID,%s,%s\r\n", symbol, maxDays);
    }

    public String HDT(String symbol, String begin, String end){ return String.format("HID,%s,%s,%s\r\n", symbol, begin, end); }

    public String HWX(String symbol, String maxWeeks){
        return String.format("HID,%s,%s\r\n", symbol, maxWeeks);
    }

    public String HMX(String symbol, String maxMonths){ return String.format("HID,%s,%s\r\n", symbol, maxMonths); }
    // tick / max pts.
    public String HTX(String symbol, String maxPts){
        return String.format("HTX,%s,%s\r\n", symbol, maxPts);
    }

    // tick / max days
    public String HTD(String symbol, String maxDays){ return String.format("HTD,%s,%s\r\n", symbol, maxDays); }

    // TODO: look up specifics for timeframe formatting

    // tick / timeframe
    // time format - CCYYMMDD HHmmSS
    public String HTT(String symbol, String begin, String end){ return String.format("HTT,%s,%s,%s\r\n", symbol, begin, end); }

    // interval by seconds / max pts.
    public String HIX(String symbol, String interval, String maxData){ return String.format("HIX,%s,%s,%s\r\n", symbol, interval, maxData); }

    // interval by seconds / max days
    public String HID(String symbol, String interval, String maxDays){ return String.format("HID,%s,%s,%s\r\n", symbol, interval, maxDays); }

    // interval, timeframe (begin, end)
    public String HIT(String symbol, String interval, String begin, String end){ return String.format("HID,%s,%s,%s,%s\r\n", symbol, interval, begin,end); }

    // daily, max days
    public String HDX(String symbol, String maxDays){
        return String.format("HID,%s,%s\r\n", symbol, maxDays);
    }

    public String HDT(String symbol, String begin, String end){ return String.format("HID,%s,%s,%s\r\n", symbol, begin, end); }
    public String HWX(String symbol, String maxWeeks){
        return String.format("HID,%s,%s\r\n", symbol, maxWeeks);
    }
    public String HMX(String symbol, String maxMonths){ return String.format("HID,%s,%s\r\n", symbol, maxMonths); }
}
