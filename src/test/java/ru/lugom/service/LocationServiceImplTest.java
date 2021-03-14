package ru.lugom.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceImplTest {
    @Autowired
    private LocationService locationService;

    @Test
    public void getLocation() throws IOException, GeoIp2Exception {
        String ipUKR = "109.254.254.163";
        String ipRUS = "62.105.128.14";
        String ipBLR = "178.168.180.206";
        String ipUSA = "89.187.177.242";
        System.out.println(locationService.getLocation(ipUKR));
        System.out.println(locationService.getLocation(ipRUS));
        System.out.println(locationService.getLocation(ipBLR));
        System.out.println(locationService.getLocation(ipUSA));
        assertEquals("Ukraine", locationService.getLocation(ipUKR));
        assertEquals("Russia", locationService.getLocation(ipRUS));
        assertEquals("Belarus", locationService.getLocation(ipBLR));
        assertEquals("United States", locationService.getLocation(ipUSA));
    }
}
