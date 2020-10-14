import com.qf.CustomerApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zxp
 * @create 2020-10-04 21:36
 */
@SpringBootTest(classes = CustomerApplication.class)
@Slf4j
@RunWith(SpringRunner.class)
public class DiscoveryTest {

    @Autowired
    private  DiscoveryClient discoveryClient;

    @Test
    public void getServers() {
        List<ServiceInstance> instances = discoveryClient.getInstances("customer-server");
        for (ServiceInstance instance : instances) {
            log.info("instance={}", instance);
        }
    }
}

