package com.iga.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iga.entities.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}
