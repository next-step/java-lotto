package step1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    private static final String NUMBERS_PATTERN = "[0-9]+";
    private Queue<Integer> numbers = new LinkedList<>();

    public Numbers(String input) {
        Matcher matcher = Pattern.compile(NUMBERS_PATTERN).matcher(input);
        while(matcher.find()) {
            numbers.add(Integer.valueOf(matcher.group()));
        }
    }

    public void add(Integer input) {
        numbers.add(input);
    }

    public Integer pick() {
        return numbers.poll();
    }

    public boolean isNotEmpty() {
        return !numbers.isEmpty();
    }
}
