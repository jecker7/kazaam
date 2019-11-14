import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.junit.*;
import requests.IQFeedHistoricalRequest;
import requests.IQFeedHistoricalRequestBuilder;

public class TestIQFeedHistoricalRequest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

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
