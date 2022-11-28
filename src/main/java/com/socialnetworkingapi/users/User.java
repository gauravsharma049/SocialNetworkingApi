package com.socialnetworkingapi.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

import javax.persistence.*;
import com.socialnetworkingapi.locations.Location;
import com.socialnetworkingapi.posts.Posts;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class User {
    @Id
    private String id;
    private String fname;
    private String lname;
    private String email;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Posts> posts;
}
