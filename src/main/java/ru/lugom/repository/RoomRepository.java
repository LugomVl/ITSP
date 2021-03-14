package ru.lugom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lugom.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
