package ru.corchan.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import ru.corchan.DAO.PostDAO;
import ru.corchan.models.Post;

import static java.lang.String.valueOf;

@Controller
@RequestMapping("/b")
public class PostController {

    private final PostDAO postDAO;

    @Autowired
    public PostController(PostDAO postDAO){
        this.postDAO =postDAO;
    }

    @GetMapping("")
    public String b(Model model) {
        model.addAttribute("posts", postDAO.showPosts());
        return "b";
    }

    @PostMapping("/new")
    public String newPost(@ModelAttribute("post") Post post, @RequestParam("image1") MultipartFile multipartFile) {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        post.setImage1(fileName);

        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("post") Post post) {
        postDAO.create(post);
        if (post.getInThread()==0)
            return "redirect:/b";
        else
            return "redirect:/b/" + valueOf(post.getInThread());
    }

    @GetMapping("/{id}")
    public String openThread(@PathVariable("id") int id, Model model) {
        model.addAttribute("post", postDAO.showPost(id));
        model.addAttribute("replies", postDAO.showReplies(postDAO.getPost(id)));
        return "b/thread";
    }
}
