package com.socialnetworkingapi.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping("/location")
    public List<Location> getAllLocation(){
        return locationService.getAllLocation();
    }

    @GetMapping("/location/{id}")
    public Location getLocation(@PathVariable("id") String id){
        return locationService.getLocation(id);
    }

    @PostMapping("/location")
    public String addLocation(@RequestBody Location location){
        locationService.addLocation(location);
        return "location added Successfully";
    }
   
    @PutMapping("/location/update/{id}")
    public String updateLocation(@PathVariable("id") String id, @RequestBody Location location){
        locationService.updateLocation(location, id);
        return "location updated Successfully";
    }

    @DeleteMapping("/location/delete/{id}")
    public String deleteLocation(@PathVariable("id") String id){
        locationService.deleteLocation(id);
        return "location with id " + id + " deleted successfully";
    }
}
