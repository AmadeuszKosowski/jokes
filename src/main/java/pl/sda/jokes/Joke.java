package pl.sda.jokes;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Joke {
    private Integer id;
    private String text;
    private String category;


}
