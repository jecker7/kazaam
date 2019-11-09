package requests;
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
    private String symbol;
    private String dataPeriod;
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
        dataPeriod = builder.dataType;
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

    public String toString(){
        // TODO: fix this mess and test it's ass ...
        String dataQualifier;
        String timeQualifier;

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
        }

        String dataRequest = new StringBuilder("H" + dataQualifier + timeQualifier);

        List<String> argsOrder = Arrays.asList(symbol, interval, maxDays, maxWeeks, maxMonths, beginDateTime, beginDate,
                endDate, maxDataPts, beginFilterTime, endFilterTime, dataDirection, requestID, dataPtsPerSend, includePartialData,
                intervalType, labelAtBeginning);

        for(String arg: argsOrder){
            if(!Objects.equals(arg, "", null)){
                dataRequest.append(arg + ",");
            }
            // remove trailing comma
            dataRequest.delete(len(dataRequest)-1);
        }
        return dataRequest;
    }

}
