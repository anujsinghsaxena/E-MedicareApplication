package com.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.bean.Medicine;
import com.medicare.service.MedicineService;

@RestController
@RequestMapping("/medicine")
@CrossOrigin
public class MedicineController {
          @Autowired
          MedicineService medicineService;
          @PostMapping(value = "storeMedicine",consumes = MediaType.APPLICATION_JSON_VALUE)
  		  public String storeMedicine(@RequestBody Medicine medicine) {
  					return medicineService.storeMedicine(medicine);
  		  }
          @PatchMapping(value = "updateMedicine")
  		  public String updateMedicine(@RequestBody Medicine medicine) {
  						return medicineService.updateMedicine(medicine);
  		  }
          //Get All Medicine
          @GetMapping("/")
          public ResponseEntity<?> getAllMedicines(){
        	  return ResponseEntity.ok(this.medicineService.getMedicines());
          }
          //Get Medicine by Id
          @GetMapping("/{medicineId}")
          public Medicine getMedicine(@PathVariable("medicineId") Integer medicineId) {
        	  return this.medicineService.getMedicine(medicineId);
          }
          
          //Category
          @GetMapping("/getbycategory/{category}")
          public List<Medicine> getmedsbycategory(@PathVariable(value="category") String category){
        	  return medicineService.getCategory(category);
          }
  		    //delete
          @DeleteMapping(value="/{medid}")
          public String deleteMedicineUsingId(@PathVariable("medid") int medid) {
              return medicineService.deleteMedicine(medid);
          }

          

}
