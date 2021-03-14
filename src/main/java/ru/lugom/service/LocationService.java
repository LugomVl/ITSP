package ru.lugom.service;

import com.maxmind.geoip2.exception.GeoIp2Exception;

import java.io.IOException;

public interface LocationService {
    String getLocation(String ip) throws IOException, GeoIp2Exception;
}
