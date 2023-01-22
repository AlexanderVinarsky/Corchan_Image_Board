package ru.corchan.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.corchan.models.Post;

import java.util.List;

@Component
public class PostDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Post> showPosts() {
        return jdbcTemplate.query("SELECT * FROM posts", new PostMapper());
    }

    public void create(Post post) {
        jdbcTemplate.update("INSERT INTO posts VALUES(DEFAULT, ?)", post.getTxt());
    }
}


    /*public Thread showPerson(int id){
        return jdbcTemplate.query("SELECT * FROM threads WHERE id = ?", new Object[]{id}, new ThreadMapper())
                .stream().findAny().orElse(null);
    }*/

    /*

    public void update(int id, Thread updatedPerson)    {
        jdbcTemplate.update("UPDATE people SET name= ? where id =?", updatedPerson.getName(), updatedPerson.getId());
    }*/

    /*public void delete(int id){
        jdbcTemplate.update("DELETE FROM threads where id = ?", id);
    }
}*/

