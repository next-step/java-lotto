package step1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {

    private static final Pattern pattern = Pattern.compile("\\d+");

    private final List<Integer> numbers = new ArrayList<>();

    public Numbers(String string) {
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
    }

    public Integer getNumbers(int index) {
        return numbers.get(index);
    }

}
