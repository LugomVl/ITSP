package ru.lugom.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

@Service
public class LocationServiceImpl implements LocationService{
    private DatabaseReader dbReader;

    public LocationServiceImpl() throws IOException {
        File database = new File("GeoLite2-City.mmdb");
        dbReader = new DatabaseReader.Builder(database).build();
    }

    public String getLocation(String ip)
            throws IOException, GeoIp2Exception {
        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse response = dbReader.city(ipAddress);
        String cityName = response.getCountry().getName();
        return cityName;
    }
}
