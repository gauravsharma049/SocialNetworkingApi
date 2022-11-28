package com.socialnetworkingapi.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Posts> getAllPosts(){
        return postRepository.findAll();
    }

    public Posts getPost(String id){
        return postRepository.findById(id).get();
    }

    public List<Posts> getPostByUser(String id){
        return postRepository.findByUserId(id);
    }
    public List<Posts> getPostByPostdate(String postdate){
        return postRepository.getPostByPostdate(postdate);
    }
    public void addPost(Posts post){
        postRepository.save(post);
    }

    public void updatePost(String id, Posts post){
        Posts posts = postRepository.getReferenceById(id);
        posts.setDetails(post.getDetails());
        posts.setPostdate(post.getPostdate());

        postRepository.save(posts);
    }

    public void deletePost(String id){
        postRepository.delete(postRepository.getReferenceById(id));
    }
}
