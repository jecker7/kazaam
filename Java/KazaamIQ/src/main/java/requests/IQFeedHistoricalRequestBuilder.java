package requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.InvalidParameterException;

public final class IQFeedHistoricalRequestBuilder {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // TODO: add in validation for individual data types
    // request strings for IQFeed interface
    // In general: timeframes are specified in the following format: CCYYMMDD HHmmSS
    // see here http://www.iqfeed.net/dev/api/docs/HistoricalviaTCPIP.cfm for more information
    // tick / max pts
    // required
    protected String symbol = "";
    protected String tickSize= "";
    // optional
    protected String beginDate= "";
    protected String beginDateTime= "";
    protected String beginFilterTime= "";
    protected String dataDirection= "";
    protected String dataPtsPerSend= "";
    protected String endDate= "";
    protected String endDateTime= "";
    protected String endFilterTime= "";
    protected String includePartialData= "";
    protected String interval= "";
    protected String intervalType= "";
    protected String labelAtBeginning= "";
    protected String maxDataPts= "";
    protected String maxDays= "";
    protected String maxMonths= "";
    protected String maxWeeks= "";
    protected String requestID= "";

    public IQFeedHistoricalRequestBuilder() {
    }

    public static IQFeedHistoricalRequestBuilder anIQFeedHistoricalRequest() {
        return new IQFeedHistoricalRequestBuilder();
    }

    public IQFeedHistoricalRequestBuilder setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public IQFeedHistoricalRequestBuilder setDataType(String dataType) {
        this.tickSize = dataType;
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
        return anIQFeedHistoricalRequest().setSymbol(symbol).setDataType(tickSize).setBeginDate(beginDate).setBeginDateTime(beginDateTime).setBeginFilterTime(beginFilterTime).setDataDirection(dataDirection).setDataPtsPerSend(dataPtsPerSend).setEndDate(endDate).setEndDateTime(endDateTime).setEndFilterTime(endFilterTime).setIncludePartialData(includePartialData).setInterval(interval).setIntervalType(intervalType).setLabelAtBeginning(labelAtBeginning).setMaxDataPts(maxDataPts).setMaxDays(maxDays).setMaxMonths(maxMonths).setMaxWeeks(maxWeeks).setRequestID(requestID);
    }



    private void validate(IQFeedHistoricalRequest request) throws Exception{
        // TODO: refactor to check for invalid parameter values, redundant/extra fields
        /*
          in general, we need the following combinations for a valid request, dependent on ticksize:
                tick: maxDataPoints || maxDays || (BeginDateTime, EndDateTime)
                interval: maxDataPoints || maxDays || (BeginFilterTime, EndFilterTime)
                day: maxDays || (beginDate, endDate)
                week: maxWeeks
                month: maxMonth
         */
        try {
            checkVal(request.symbol);
            switch(request.dataPeriod.toLowerCase()){
                case "tick":
                    if((checkVal(request.maxDataPts) || checkVal(request.maxDays) ||
                            (checkVal(request.beginDateTime) && checkVal(request.endDateTime)))){
                        throw new InvalidParameterException("Invalid parameters for request of tick size: tick");
                    }
                case "day":
                    if((checkVal(request.maxDays) || (checkVal(request.beginDate) && checkVal(request.beginDate)))){
                        throw new InvalidParameterException("Invalid parameters for request of tick size: day");
                    }
                case "interval":
                    if((checkVal(request.maxDataPts) || checkVal(request.maxDays) ||
                            (checkVal(request.beginFilterTime) && checkVal(request.endFilterTime)))){
                        throw new InvalidParameterException("Invalid parameters for request of tick size: interval");
                    }
                case "week":
                    if(!checkVal(request.maxWeeks)){
                        throw new InvalidParameterException("Invalid parameters for request of tick size: week");
                    }
                case "month":
                    if(checkVal(request.maxMonths)) {
                        throw new InvalidParameterException("Invalid parameters for request of tick size: month");
                    }
            }
        } catch(Exception e) {
            logger.error(e.getMessage());
        }
    }

    private boolean checkVal(String val) {
        if(val == "" || val == null){
            return false;
        }
        return true;
    }

    public IQFeedHistoricalRequest build() throws Exception {
        IQFeedHistoricalRequest request = new IQFeedHistoricalRequest(this);
        try {
            validate(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return new IQFeedHistoricalRequest(this);
    }
}
