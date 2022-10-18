package com.medicare.repository;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.bean.Medicine;

import antlr.collections.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Integer> {
	public java.util.List<Medicine> findByCategory(String category);
}
