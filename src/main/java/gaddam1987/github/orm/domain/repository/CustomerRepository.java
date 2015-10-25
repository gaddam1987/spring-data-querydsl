package gaddam1987.github.orm.domain.repository;

import gaddam1987.github.orm.domain.Customer;
import gaddam1987.github.orm.domain.EmailAddress;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Long>{
    Customer findByEmailAddress(EmailAddress emailAddress);
}
