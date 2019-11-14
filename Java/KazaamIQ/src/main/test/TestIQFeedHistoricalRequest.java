import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.*;
import requests.IQFeedHistoricalRequest;
import requests.IQFeedHistoricalRequestBuilder;

import java.util.Objects;

public class TestIQFeedHistoricalRequest {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testIQFeedHistoricalRequestBuilder(){
        try {
            String request = new IQFeedHistoricalRequestBuilder()
                    .setRequestID("ID")
                    .setDataType("I")
                    .setBeginDateTime("time1")
                    .setEndDateTime("time2")
                    .build().toString();
            System.out.println(" request: " + request);
        } catch(Exception e){
            logger.error(e.getMessage());
        }
    }
}
