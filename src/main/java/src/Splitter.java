package src;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class Splitter {

    public Deque<String> split(String value) {
        validate(value);

        return new LinkedList<>(Arrays.asList(value.split(" ")));
    }

    private void validate(String value) {
        if (Objects.isNull(value) || value.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
