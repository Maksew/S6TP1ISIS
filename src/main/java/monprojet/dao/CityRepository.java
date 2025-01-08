package monprojet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import monprojet.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

    /**
     * Trouve une ville par son nom.
     * @param cityName
     * @return La ville correspondant au nom fourni, ou null si pas trouvé.
     */
    public City findByName(String cityName);
}
