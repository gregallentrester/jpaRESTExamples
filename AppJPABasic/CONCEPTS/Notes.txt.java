
/*

JPA is a SPEC.
Implemention can be Hibernate.


Repo interface must exist within the same
package/subpackage of @SpringBootApplication

else, use @EnableJpaRepositories using type-safe parameter:
    basePackageClasses=AlternateRepo.class


@SpringBootApplication - combines 3 annotations (CES):

  @Configuration -
      Source of bean definitions for application context

  @EnableAutoConfiguration -
      Beans added via other beans, property settings, classpath settings.
      org.springframework.data.jpa.repository.config

  @ComponentScan -
      Within app-root's package, scans Components; Configurations; Services.

*/


// Summary
@SpringBootApplication (CES)
  @Configuration
  @EnableAutoConfiguration
  @ComponentScan



// REPO <<Interface>>
import org.springframework.data.repository.CrudRepository;
public interface VendorRepository extends CrudRepository<Vendor, Long> {
	Vendor findById(long id);
}


// ENTITY
import javax.persistence.*;
@Entity
public class Vendor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	protected Vendor() { }
}


// APP
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Bean
	public CommandLineRunner demo(VendorRepository repo) {
		return (args) -> {
      // shit
	});
}


// SERVICE
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VendorService {

  @Autowired
  private VendorRepo repo;

  public void addVendor(Vendor vendor) {
    repo.save(vendor);
  }
}


// CUSTOM_QUERY
@Component  // match repoName + 'Impl'
public class VendorRepoImpl {

  private final String HQL =
    "SELECT vend FROM Vendor vend WHERE vend.id = :id";

  @PersistenceContext
  private EntityManager em;

  @Autowired
  private VendorRepo repo;

  @SuppressWarnings("unused")
  public List<Vendor> viaHQL(Long id) {
    TypedQuery<Vendor> query =
      em.createQuery(HQL, Vendor.class);
  }
}


// REST_CONTROLLER
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VendorController {

  @Autowired
  private VendorService service;

  @RequestMapping("/")
  public List<Vendor> findAllVendors() {
    return service.findAllVendors();
  }

  @RequestMapping(value="/add-vendor", method=RequestMethod.POST)
  public void addVendor(@RequestBody Vendor vendor) {
    service.addVendor(vendor);
  }
}


// SUMMARY
Apache Derby - In-memory database.

@SpringBootApplication (CES)
   @Configuration
   @EnableAutoConfiguration
   @ComponentScan

 
// Repo <<Interface>>
public interface VendorRepository extends CrudRepository<Vendor, Long> { ... }


// Entity
@Entity
public class Vendor {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)

 
// App
@SpringBootApplication
public class App {
 public static void main(String[] args) {
   SpringApplication.run(App.class);
 }

 @Bean
 public CommandLineRunner demo(VendorRepository repo) {
   return (args) -> {
     // shit
 });


// Service
@Service
@Autowired (Repo)
repo.save(vendor);


// Custom Query
@Component
@PersistenceContext  (EntityManager)
@Autowired (Repo)
@SuppressWarnings("unused")
TypedQuery = em.createQuery()


// REST Controller
@RestController
@Autowired (service)
@RequestMapping(value="/add-vendor", method=RequestMethod.POST)
public void addVendor(@RequestBody Vendor vendor) { … }
