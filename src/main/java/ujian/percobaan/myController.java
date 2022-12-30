/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ujian.percobaan;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ujian.percobaan.exceptions.NonexistentEntityException;

/**
 *
 * @author Isa Jaisyullah
 */

@Controller
@ResponseBody
public class myController {
    
    Barang data = new Barang();
    BarangJpaController cont = new BarangJpaController();

    //GetAll
    @RequestMapping("/barang")
    public List<Barang> getBarang (){    
     return cont.findBarangEntities();
    }
    
    //Create, input data
    @RequestMapping(value = "/create", method = RequestMethod.POST) 
    public String createProduct(@RequestBody Barang barang) {
        
        try {
            cont.create(barang);
            return "barang is created successfully";
        } catch (Exception ex) {
            return "gagal";
        } 
    }
    
    //delete data
   @RequestMapping("/delete/{id}")
    public String delId(@PathVariable("id") int id){
            try {
                cont.destroy(id);
                return id + " dihapus";        
        } catch (NonexistentEntityException error) { return "Data tidak ada"; }
    }
    
    
    
}
