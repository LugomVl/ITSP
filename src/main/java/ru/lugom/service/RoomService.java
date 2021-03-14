package ru.lugom.service;

import ru.lugom.model.Room;

import java.util.List;
import java.util.Optional;


public interface RoomService {
    Room create(Room room);
    List<Room> findAll();
    Optional<Room> findRoomById(long id);
    Room update(Room room);
}
