package requests;

public final class IQFeedHistoricalRequestBuilder {

    // TODO: add in validations
    // request strings for IQFeed interface
    // In general: timeframes are specified in the following format: CCYYMMDD HHmmSS
    // see here http://www.iqfeed.net/dev/api/docs/HistoricalviaTCPIP.cfm for more information
    // tick / max pts
    // required
    protected String symbol;
    protected String requestType;
    // optional
    protected String beginDate;
    protected String beginDateTime;
    protected String beginFilterTime;
    protected String dataDirection;
    protected String dataPtsPerSend;
    protected String endDate;
    protected String endDateTime;
    protected String endFilterTime;
    protected String includePartialData;
    protected String interval;
    protected String intervalType;
    protected String labelAtBeginning;
    protected String maxDataPts;
    protected String maxDays;
    protected String maxMonths;
    protected String maxWeeks;
    protected String requestID;

    private IQFeedHistoricalRequestBuilder() {
    }

    public static IQFeedHistoricalRequestBuilder anIQFeedHistoricalRequest() {
        return new IQFeedHistoricalRequestBuilder();
    }

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

    public IQFeedHistoricalRequestBuilder but() {
        return anIQFeedHistoricalRequest().setSymbol(symbol).setRequestType(requestType).setBeginDate(beginDate).setBeginDateTime(beginDateTime).setBeginFilterTime(beginFilterTime).setDataDirection(dataDirection).setDataPtsPerSend(dataPtsPerSend).setEndDate(endDate).setEndDateTime(endDateTime).setEndFilterTime(endFilterTime).setIncludePartialData(includePartialData).setInterval(interval).setIntervalType(intervalType).setLabelAtBeginning(labelAtBeginning).setMaxDataPts(maxDataPts).setMaxDays(maxDays).setMaxMonths(maxMonths).setMaxWeeks(maxWeeks).setRequestID(requestID);
    }

    public IQFeedHistoricalRequest build() {
        return new IQFeedHistoricalRequest(this);
    }
}
