package monprojet.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.log4j.Log4j2;
import monprojet.entity.City;
import monprojet.entity.Country;

@Log4j2
@DataJpaTest
public class CityRepositoryTest {

    @Autowired
    private CountryRepository countryDAO;
    @Autowired
    private CityRepository cityDAO;

    @Test
    void onTrouveLePaysDesVilles() {
        log.info("On vérifie que les pays des villes sont bien récupérés");
        City paris = cityDAO.findByName("Paris");
        Country france = countryDAO.findById(1).orElseThrow();
        assertEquals(france, paris.getCountry(), "Paris est en France");
    }

    @Test
    void onVerifieLaPopulationDeLaVille() {
        log.info("On vérifie que la population de New York est correcte");
        City newYork = cityDAO.findByName("New York");
        assertEquals(27, newYork.getPopulation(), "La population de New York est bien 27");
    }

    @Test
    void onTrouveLesVillesDesPays() {
        log.info("On vérifie que les villes d'un pays sont accessibles");
        City paris = cityDAO.findByName("Paris");  // Ville Paris
        Country france = countryDAO.findById(1).orElseThrow();  // Pays France
        assertTrue(france.getCities().contains(paris), "France contient Paris");
    }
}
