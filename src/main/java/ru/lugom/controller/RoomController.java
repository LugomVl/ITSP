package ru.lugom.controller;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import ru.lugom.model.Room;
import ru.lugom.service.LocationService;
import ru.lugom.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private LocationService service;

    @GetMapping
    public ModelAndView mainPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }

    @GetMapping("/rooms")
    public ModelAndView allRooms(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(roomService.findAll());
        modelAndView.setViewName("rooms");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView room(@PathVariable long id, HttpServletRequest request) throws IOException, GeoIp2Exception {
        String ip = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getRemoteAddr();
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            ip = in.readLine(); //you get the IP as a String
        }
        ModelAndView modelAndView = new ModelAndView();
        String country = service.getLocation(ip);
        Room room = roomService.findRoomById(id).get();
        if (!country.equals(room.getCountry())) {
            modelAndView.addObject("error", "This room is not available for your country!");
            modelAndView.setViewName("rooms");
            modelAndView.addObject(roomService.findAll());
            return modelAndView;
        }
        modelAndView.addObject(room);
        modelAndView.setViewName("roomPage");
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("create");
        return modelAndView;
    }

    @PostMapping(value="/create")
    public ModelAndView addRoom(@ModelAttribute Room room){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/rooms");
        roomService.create(room);
        return modelAndView;
    }
}
