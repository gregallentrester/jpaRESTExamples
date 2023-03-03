/*
 Spring - https://bit.ly/3pPPAW1
 Apache Derby - In-memory database.
*/

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity  // missing @Table annotation means entity maps to SQL table Vendor
public class Vendor {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String industryName;
  private String product;

  protected Vendor() { }

  public Long getId() { return id; }
  public String getIndustryName() { return industryName; }
  public String getProduct() { return product; }

  public Vendor(String nameVal, String prodVal) {
    industryName = nameVal;
    product = prodVal;
  }
}



import org.springframework.data.repository.CrudRepository;

public interface VendorRepo extends CrudRepository<Vendor, Long> {

  List<Vendor> findByLastName(String product);

  Vendor findById(long id);
}







import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Bean
  public CommandLineRunner demo(VendorRepo repo) {
    return (args) -> {

      repo.save(new Vendor("APPLE", "M2"));
      repo.save(new Vendor("INTEL", "ALPHA"));
      repo.save(new Vendor("INTEL", "HX"));


      // A. fetch all Vendors
      for (Vendor vendor : repo.findAllVendors()) {
        return service.findAllVendors();
      }


      // B. fetch Vendor by ID
      Vendor vendor = repo.findById(1L);
      System.err.println(vendor);


      // C1.
      repo.findByLastName("M2").forEach(vendor -> {
        System.err.println(vendor);
      });

      // C2.
      for (Vendor vendor : repo.findByLastName("M2")) {
        System.err.println(vendor);
      }
    };
  }
}


@Service
public class VendorService {

  @Autowired
  private VendorRepo repo;


  public void addVendor(Vendor vendor) {
    repo.save(vendor);
  }


  public List<Vendor> findAllVendors() {
    List<Vendor>vendors = new ArrayList();

    repo.findAll().forEach(vendors::add);

    return vendors;
  }
}
