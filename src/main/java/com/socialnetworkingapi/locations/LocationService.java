package com.socialnetworkingapi.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository ;

    public List<Location> getAllLocation(){
        return locationRepository.findAll();
    }
    
    public Location getLocation(String id){
        return locationRepository.findById(id).get();
    }

    public void addLocation(Location location){
        locationRepository.save(location);
    }

    public void updateLocation(Location location, String id){
        Location loc = locationRepository.getReferenceById(id);
        loc.setName(location.getName());
        locationRepository.save(loc);
    }

    public void deleteLocation(String id){
        locationRepository.delete(locationRepository.getReferenceById(id));
    }
}
