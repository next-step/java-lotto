package calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tokenizer {

    private final String delimiter;

    public Tokenizer(String delimiter) {
        this.delimiter = delimiter;
    }

    public Queue<String> queue(String input) {
        return new LinkedList<>(List.of(input.split(delimiter)));
    }
}
