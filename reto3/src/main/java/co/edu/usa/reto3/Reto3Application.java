package co.edu.usa.reto3;



import co.edu.usa.reto3.modelo.Admin;
import co.edu.usa.reto3.modelo.Cuatrimotos;
import co.edu.usa.reto3.modelo.Categoria;
import co.edu.usa.reto3.modelo.Clientes;
import co.edu.usa.reto3.modelo.Mensajes;
import co.edu.usa.reto3.modelo.Puntaje;
import co.edu.usa.reto3.modelo.Reservas;
import co.edu.usa.reto3.repositorios.AdminRepository;
import co.edu.usa.reto3.repositorios.CuatrimotoRepository;
import co.edu.usa.reto3.repositorios.CategoriaRepository;
import co.edu.usa.reto3.repositorios.ClientesRepository;
import co.edu.usa.reto3.repositorios.MensajesRepository;
import co.edu.usa.reto3.repositorios.PuntajeRepository;
import co.edu.usa.reto3.repositorios.ReservasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.ApplicationArguments;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.usa.reto3"})
public class Reto3Application {

    @Autowired
    private CuatrimotoRepository repoCuatrimotos;
    
     @Autowired
    private CategoriaRepository repoCategorias;
     
     @Autowired   
    private ClientesRepository repoClientes;
    
    @Autowired
    private MensajesRepository repoMensajes;
    
     @Autowired
    private ReservasRepository repoReservas;
   
      @Autowired
    private AdminRepository repoAdmin;
   
     @Autowired
    private PuntajeRepository repoPuntaje;
   
   
    public static void main(String[] args) {
        SpringApplication.run(Reto3Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return (ApplicationArguments args) -> {    
            List<Cuatrimotos> ps = repoCuatrimotos.getAll();
                    System.out.println("Quadbike: " + ps.size());

            List<Categoria> cs = repoCategorias.getAll();
                    System.out.println("Category: " + cs.size());

            List<Clientes> cli = repoClientes.getAll();
                    System.out.println("Client: " + cs.size());
                    
            List<Mensajes> ms = repoMensajes.getAll();
                    System.out.println("Message: " + cs.size());  
                    
             List<Reservas> rs = repoReservas.getAll();
                    System.out.println("Reservation: " + cs.size());  
                    
                    
             List<Admin> am = repoAdmin.getAll();
                    System.out.println("Admin: " + cs.size());  
                    
             List<Puntaje> ap = repoPuntaje.getAll();
                    System.out.println("score: " + cs.size());  
                                      
        };
    }
}

    
    
        
        
        
       

                
  

    

