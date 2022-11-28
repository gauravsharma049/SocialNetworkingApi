package com.socialnetworkingapi.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.socialnetworkingapi.users.User;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public List<Posts> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/posts/{id}")
    public Posts getPost(@PathVariable("id") String id){
        return postService.getPost(id);
    }

    @GetMapping("/posts/user/{id}")
    public String getPostByUser(@PathVariable("id") String id, Model model){
        model.addAttribute("posts", postService.getPostByUser(id));
        model.addAttribute("post", new Posts());
        return "postbyuser";
    }

    @GetMapping("/posts/postdate/{postdate}")
    public List<Posts> getPostByPostdate(@PathVariable("postdate") String postdate){
        return postService.getPostByPostdate(postdate);
    }

    @PostMapping("/posts")
    public String addPost(@ModelAttribute("post") Posts post, @RequestParam("userid") String userid){
        User user = new User();
        user.setId(userid);
        post.setUser(user);
        postService.addPost(post);
        return "redirect:/posts/user/"+userid;
    }

    @PutMapping("/posts/update/{id}")
    public String updatePost(@PathVariable("id") String id, @RequestBody Posts post){
        postService.updatePost(id, post);
        return "post updated successfully";
    }

    @RequestMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable("id") String id){
        String uId = postService.getPost(id).getUser().getId();
        postService.deletePost(id);
        return "redirect:/posts/user/"+uId;
    }
}
