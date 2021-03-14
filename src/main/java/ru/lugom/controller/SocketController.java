package ru.lugom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MessageConversionException;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.lugom.model.Room;
import ru.lugom.service.RoomService;

@Controller
public class SocketController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting(String message) throws Exception {
        System.out.println(message);
        return "abracadabra";
    }
    /*@Autowired
    private RoomService roomService;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    @MessageExceptionHandler(MessageConversionException.class)
    public String change(String room) throws Exception {
        System.out.println("Let`s work");
        System.out.println(room.toString());
        //roomService.update(room);
        //return roomService.findRoomById(room.getId());
        return "Hello mf1";
    }*/
}
