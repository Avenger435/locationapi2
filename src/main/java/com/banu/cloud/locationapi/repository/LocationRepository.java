package com.banu.cloud.locationapi.repository;
import com.banu.cloud.locationapi.model.Location;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Location , Long> {

	@Query(value = "SELECT CITY,COUNTRYNAME,GEOID FROM GEO_SITE WHERE CITY = ?", nativeQuery = true)
	  Location findcitybyname(String city);
	
	@Query(value="SELECT * FROM REFDATA.GEO_SITE ORDER BY ID",nativeQuery=true)
	List<Location> findAll();
	
	Iterable<Location> findByCityIgnoreCase(String city);
}
