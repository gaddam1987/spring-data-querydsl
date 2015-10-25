package gaddam1987.github.orm.config;

import gaddam1987.github.orm.domain.Address;
import gaddam1987.github.orm.domain.Customer;
import gaddam1987.github.orm.domain.EmailAddress;
import gaddam1987.github.orm.domain.repository.CustomerRepository;
import org.flywaydb.core.Flyway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;


@ContextConfiguration(classes = DatabaseConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DatabaseConfigurationTest {

    @Autowired
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        /**
         Flyway flyway = new Flyway();
         flyway.setDataSource("jdbc:mysql://localhost:3306/hibernate","hibernate","hibernate");
         flyway.clean();

         **/
        Customer customer = new Customer("naresh", "Reddy");
        customer.setEmailAddress(new EmailAddress("gaddam.1987@gmail.com"));

        customer.add(new Address("Nydalen","Oslo","Norway"));

        customerRepository.save(customer);
    }


    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void loadedBeans() {
        Customer byEmailAddress = customerRepository.findByEmailAddress(new EmailAddress("gaddam.1987@gmail.com"));
        System.out.println("*********************************************************");
        System.out.println(byEmailAddress);
        System.out.println("**********************************************************");

    }


}