/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Admin;
import co.edu.usa.reto3.repositorios.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanyi
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();  
    }
     public Admin save(Admin admin){
        return adminRepository.save(admin);
    }
     public Admin getById(int id){
        Optional<Admin> admin= adminRepository.getById(id);
        return admin.orElse(new Admin());
}
     
      public Admin updateAdmin(Admin admin) {        
        if (admin.getId() != null){
            Optional<Admin> adminConsultada = adminRepository.getById(admin.getId());
            if (adminConsultada.isPresent()){
                adminConsultada.get().setEmail(admin.getEmail());
                adminConsultada.get().setName(admin.getName());
                adminConsultada.get().setPassword(admin.getPassword());
                
                return adminRepository.save(adminConsultada.get());
            }
        }
         return admin;
    }
       public boolean deleteAdmin(int id) {
        boolean del = adminRepository.getById(id).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return del;
    }
}