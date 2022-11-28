package com.socialnetworkingapi.posts;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.socialnetworkingapi.users.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Posts {
    @Id
    private String id;
    private String postdate;
    private String details;

    @ManyToOne
    @JsonBackReference
    private User user;
}
