package com.iga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iga.entities.Equipment;
import com.iga.entities.Room;
import com.iga.repositories.EquipmentRepository;
import com.iga.repositories.RoomRepository;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;
    
    @Autowired
    private RoomRepository roomRepository;

    public List<Equipment> getAllEquipment() {
        try {
            return equipmentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la récupération des équipements : " + e.getMessage(), e);
        }
    }

    public Equipment saveEquipment(String name, String type, Integer quantity, Long roomId) {
    	 try {
    		 Room existingRoom = roomRepository.findById(roomId).orElseThrow(() -> new IllegalArgumentException("Room ID " + roomId + " not found."));;
    		 Equipment newEquipment = new Equipment(name, type, quantity, existingRoom);
    		 return equipmentRepository.save(newEquipment);
         } catch (Exception e) {
             throw new RuntimeException("Erreur lors de la récupération des équipements : " + e.getMessage(), e);
         }
    }

    public void deleteEquipment(Long id) {
    	try {
            equipmentRepository.deleteById(id);
	     } catch (Exception e) {
	         throw new RuntimeException("Erreur lors de la récupération des équipements : " + e.getMessage(), e);
	     }
    }
}
