package gaddam1987.github.orm.domain;

import org.springframework.util.Assert;

import javax.persistence.Entity;

import static org.springframework.util.Assert.hasText;

@Entity
public class Address extends AbstractEntity {

    private String street, city, country;

    /**
     * Creates a new {@link Address} from the given street, city and country.
     *
     * @param street must not be {@literal null} or empty.
     * @param city must not be {@literal null} or empty.
     * @param country must not be {@literal null} or empty.
     */
    public Address(String street, String city, String country) {

        hasText(street, "Street must not be null or empty!");
        hasText(city, "City must not be null or empty!");
        hasText(country, "Country must not be null or empty!");

        this.street = street;
        this.city = city;
        this.country = country;
    }

    protected Address() {

    }

    /**
     * Returns a copy of the current {@link Address} instance which is a new entity in terms of persistence.
     *
     * @return
     */
    public Address getCopy() {
        return new Address(this.street, this.city, this.country);
    }

    /**
     * Returns the street.
     *
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     * Returns the city.
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns the country.
     *
     * @return
     */
    public String getCountry() {
        return country;
    }
}
