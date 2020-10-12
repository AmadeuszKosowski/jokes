package pl.sda.jokes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class JokeController {
    private final JokeRepository jokeRepository;

    @GetMapping("/jokes")
    public String allJokes(Model model) {
        model.addAttribute("jokes", jokeRepository.getAll());
        return "jokes";
    }

    @GetMapping("/joke")
    public String joke(Model model) {
        String randomJoke = jokeRepository.getRandomJoke();
        log.info(randomJoke);
        model.addAttribute("joke", randomJoke);
        return "joke";
    }

    @PostMapping("/joke")
    public String addJoke(@RequestParam String newJoke){
        jokeRepository.add(newJoke);
        log.info("Joke repository has {} jokes", jokeRepository.jokesCount());
        return "redirect:/joke";
    }

}
