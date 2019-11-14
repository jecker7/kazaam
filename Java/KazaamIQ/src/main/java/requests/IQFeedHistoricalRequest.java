package requests;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class IQFeedHistoricalRequest {

    // TODO: refactor,  add validation

    // request strings for IQFeed interface
    // In general: timeframes are specified in the following format: CCYYMMDD HHmmSS
    // see here http://www.iqfeed.net/dev/api/docs/HistoricalviaTCPIP.cfm for more information
    // tick / max pts
    // required
    public String symbol;
    public String dataPeriod;
    // optional
    public String beginDate;
    public String beginDateTime;
    public String beginFilterTime;
    public String dataDirection;
    public String dataPtsPerSend;
    public String endDate;
    public String endDateTime;
    public String endFilterTime;
    public String includePartialData;
    public String interval;
    public String intervalType;
    public String labelAtBeginning;
    public String maxDataPts;
    public String maxDays;
    public String maxMonths;
    public String maxWeeks;
    public String requestID;


    public IQFeedHistoricalRequest(IQFeedHistoricalRequestBuilder builder) {
        symbol = builder.symbol;
        dataPeriod = builder.tickSize;
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
       // validating the requests here
    }

    public String toString() throws InvalidParameterException {
        // TODO: null checks, update lang level to support Objects.Equals()
        String dataQualifier = null;
        String timeQualifier = null;

        switch (dataPeriod.toLowerCase()) {
            // TODO: finish up here
            // TODO: convert strings to enums
            case ("tick"):
                dataQualifier = "T";
            case ("day"):
                dataQualifier = "D";
            case ("interval"):
                dataQualifier = "I";
            case ("week"):
                dataQualifier = "W";
            case ("month"):
                dataQualifier = "M";
        }

        if(maxDataPts != null){
            timeQualifier = "X";
        } else if (maxDays != null){
            timeQualifier = "D";
        } else if (beginDateTime != null && endDateTime != null){
            timeQualifier = "T";
        } else {
            throw new InvalidParameterException("Invalid time Qualifier");
        }

        StringBuilder dataRequest = new StringBuilder("H");

        if((dataQualifier != null) && (timeQualifier != null) ) {
            dataRequest.append(dataQualifier);
            dataRequest.append(timeQualifier);
        }

        // arguments for historical requests follow the hierarchy shown below
        List<String> argsOrder = Arrays.asList(symbol, interval, maxDays, maxWeeks, maxMonths, beginDateTime, beginDate,
                endDate, maxDataPts, beginFilterTime, endFilterTime, dataDirection, requestID, dataPtsPerSend, includePartialData,
                intervalType, labelAtBeginning);

        for(String arg: argsOrder){
            // TODO: convert to Objects.equals
            if(arg != "" && arg != null){
                dataRequest.append(arg + ",");
            }
            // remove trailing comma
            dataRequest.deleteCharAt(dataRequest.length()-1);
        }

        return dataRequest.toString();
    }

}
