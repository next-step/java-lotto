package calculator.domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Parser {

    public Queue<String> parseString(String input) {

        if (input == null || input.equals("")) {
            throw new IllegalArgumentException("공백값이 올 수 없습니다");
        }

        String[] strings = input.split(" ");

        Queue<String> queue = new LinkedList<>();
        Arrays.stream(strings).forEach(string -> queue.add(string));
        return queue;
    }
}
