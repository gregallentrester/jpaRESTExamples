
/*
 Javapoint - https://bit.ly/3ToEjtc
 Apache Derby - In-memory database.
*/

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
