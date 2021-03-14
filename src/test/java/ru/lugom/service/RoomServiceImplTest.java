package ru.lugom.service;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.lugom.model.Room;
import ru.lugom.repository.RoomRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomServiceImplTest {
    @Autowired
    private RoomService roomService;
    @MockBean
    private RoomRepository roomRepository;

    @Before
    public void setUp() {
        Room one = new Room(1L, "one", "Belarus", "on");
        Room two = new Room(2L, "two", "Ukraine", "off");
        Room three = new Room(3L, "three", "Russia", "on");
        Room four = new Room(4L, "four", "Belarus", "on");
        Room testRoom = new Room(0L, "five", "USA", "off");
        Room testRoomAfterSaving = new Room(5L, "five", "USA", "off");
        List<Room> rooms = Arrays.asList(one, two, three);
        Mockito.when(roomRepository.findById(2L)).thenReturn(Optional.of(two));
        Mockito.when(roomRepository.findById(3L)).thenReturn(Optional.of(three));
        Mockito.when(roomRepository.findById(4L)).thenReturn(Optional.of(four));
        Mockito.when(roomRepository.findById(5L)).thenReturn(Optional.of(testRoom));
        Mockito.when(roomRepository.save(any(Room.class))).thenReturn(testRoomAfterSaving);
        Mockito.when(roomRepository.findAll()).thenReturn(rooms);
    }

    @Test
    public void create() {
        Room testRoom = new Room(0L, "five", "USA", "off");
        testRoom = roomService.create(testRoom);
        Optional<Room> optionalRoom = roomService.findRoomById(testRoom.getId());
        assertNotNull(optionalRoom.orElse(null));
    }

    @Test
    public void findAll() {
        List<Room> rooms = roomRepository.findAll();
        assertEquals(3, rooms.size());
    }

    @Test
    public void findRoomById() {
        Optional<Room> room = roomRepository.findById(2L);
        assertTrue(room.isPresent());
    }

    @Test
    public void update() {
        Optional<Room> optionalRoom = roomService.findRoomById(4L);
        Room room = optionalRoom.orElseThrow(RuntimeException::new);
        room.setLight("off");
        roomService.update(room);
        optionalRoom = roomService.findRoomById(room.getId());
        assertEquals("on", room.getLight());
    }
}
