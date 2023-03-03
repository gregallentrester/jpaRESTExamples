/*
  SO Custom HQL - https://bit.ly/3QP083D
  Apache Derby - In-memory database.
 */

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

    query.setParameter("id", id);

    return query.getResultList();
  }
}
