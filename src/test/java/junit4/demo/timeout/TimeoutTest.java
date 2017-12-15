package junit4.demo.timeout;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TimeoutTest {
    @Test(timeout=1500)
    public void testWithTimeout() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1); // sleep for 1 second, test pass
//        TimeUnit.SECONDS.sleep(2); // sleep for 2 second, test fail
    }
}
