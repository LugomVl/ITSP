package ru.lugom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lugom.model.Room;
import ru.lugom.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    RoomRepository roomRepository;

    @Override
    @Transactional
    public Room create(Room room) {
        return roomRepository.save(room);
    }

    @Override
    @Transactional
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Room> findRoomById(long id) {
        return roomRepository.findById(id);
    }

    @Override
    @Transactional
    public Room update(Room room) {
        if (room.getLight().equals("on")) {
            room.setLight("off");
        } else {
            room.setLight("on");
        }
        return roomRepository.save(room);
    }
}
