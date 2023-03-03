
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VendorService {

  @Autowired
  private VendorRepo repo;


  public void addVendor(Vendor vendor) {
    repo.save(vendor);
  }


  public List<Vendor> findAllVendors() {
    List<Vendor> vendors = new ArrayList();

    repo.findAll().forEach(vendors::add);

    return vendors;
  }
}
