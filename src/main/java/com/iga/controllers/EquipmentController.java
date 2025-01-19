package com.iga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iga.entities.Equipment;
import com.iga.services.EquipmentService;

import DTO.EquipmentDTO;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> getAllEquipment() {
        return equipmentService.getAllEquipment();
    }

    @PostMapping
    public Equipment createEquipment(@RequestBody EquipmentDTO equipmentDTO) {
    	return equipmentService.saveEquipment(
    	        equipmentDTO.getName(),
    	        equipmentDTO.getType(),
    	        equipmentDTO.getQuantity(),
    	        equipmentDTO.getRoomId()
    	    );
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable Long id) {
        equipmentService.deleteEquipment(id);
    }
}
