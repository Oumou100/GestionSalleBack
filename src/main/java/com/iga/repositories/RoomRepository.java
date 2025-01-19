package com.iga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iga.entities.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
	@Query("SELECT r FROM Room r LEFT JOIN FETCH r.equipmentList")
	List<Room> findAllWithEquipment();
}