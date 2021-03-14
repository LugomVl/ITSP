package ru.lugom.service;

import java.util.List;
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
    public void create(Room room) {
        roomRepository.save(room);
    }

    @Override
    @Transactional
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    @Transactional
    public Room findRoomById(long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void update(Room room) {
        if (room.isLight()) {
            room.setLight(false);
        } else {
            room.setLight(true);
        }
        roomRepository.save(room);
    }
}
