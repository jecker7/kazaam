import org.junit.*;
import requests.IQFeedHistoricalRequest;
import requests.IQFeedHistoricalRequestBuilder;

public class TestIQFeedHistoricalRequest {

    @Test
    public void testIQFeedHistoricalRequestBuilder(){
        IQFeedHistoricalRequest request = new IQFeedHistoricalRequestBuilder()
                .setRequestID("ID")
                .setDataType("I")
                .setBeginDateTime("time1")
                .setEndDateTime("time2")
                .build();
        System.out.println(request);
    }
}
