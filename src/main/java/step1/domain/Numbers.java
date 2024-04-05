package step1.domain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {

    private static final Pattern pattern = Pattern.compile("\\d+");
    private Queue<Integer> numbers = new LinkedList<>();

    public Numbers(String string) {
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
    }


    public int poll() {
        return numbers.poll();
    }
}
