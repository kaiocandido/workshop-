package com.example.workshopingmongo.config;

import com.example.workshopingmongo.dto.AuthorDto;
import com.example.workshopingmongo.repository.PostRepository;
import com.example.workshopingmongo.repository.UserRepository;
import domain.Post;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.TimeZone;


@Configuration
public class instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "maria Brown", "maria@gmail.com");
        User alex = new User(null, "alex Brown", "alex@gmail.com");
        User bob = new User(null, "bob Brown", "bob@gmail.com");

        userRepository.save(maria);
        userRepository.save(alex);
        userRepository.save(bob);

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei Feliz hoje", new AuthorDto(maria));

        postRepository.save(post1);
        postRepository.save(post2);

        maria.getPosts().add(post1);
        maria.getPosts().add(post2);
        userRepository.save(maria);

    }
}
