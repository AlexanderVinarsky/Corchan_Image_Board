package ru.corchan.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.corchan.DAO.PostDAO;
import ru.corchan.models.Post;

@Controller
@RequestMapping("/test")
public class PostController {

    private final PostDAO postDAO;

    @Autowired
    public PostController(PostDAO postDAO){
        this.postDAO =postDAO;
    }

    @GetMapping("/b")
    public String b(Model model) {
        model.addAttribute("posts", postDAO.showPosts());
        return "b";
    }

    @GetMapping("/new")
    public String newPost(@ModelAttribute("post") Post post) {
        //post.addAttribute("post", new Post());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("post") Post post) {
        postDAO.create(post);
        return "redirect:test/b";
    }
}
