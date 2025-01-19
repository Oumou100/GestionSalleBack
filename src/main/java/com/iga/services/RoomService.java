package com.iga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iga.entities.Room;
import com.iga.repositories.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
    	try {
    		return roomRepository.findAllWithEquipment();
	     } catch (Exception e) {
	         throw new RuntimeException("Erreur lors de la récupération des équipements : " + e.getMessage(), e);
	     }
    }

    public Room saveRoom(Room room) {
    	try {
            return roomRepository.save(room);
	     } catch (Exception e) {
	         throw new RuntimeException("Erreur lors de la récupération des équipements : " + e.getMessage(), e);
	     }
    }

    public void deleteRoom(Long id) {
    	try {
            roomRepository.deleteById(id);
	     } catch (Exception e) {
	         throw new RuntimeException("Erreur lors de la récupération des équipements : " + e.getMessage(), e);
	     }
    }
}
