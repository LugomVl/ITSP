package ru.lugom.service;

import ru.lugom.model.Room;

import java.util.List;


public interface RoomService {
    void create(Room room);
    List<Room> findAll();
    Room findRoomById(long id);
    void update(Room room);
}
