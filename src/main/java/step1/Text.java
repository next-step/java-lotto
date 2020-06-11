package step1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Text {

    private final String text;

    public Text(String text) {
        this.text = text;
    }

    public String[] split(String delimiter) {
        return text.split(delimiter);
    }

    public List<Number> parseNumber(String[] list) {
        return Arrays.stream(list)
                .map(text -> new Number(text))
                .collect(Collectors.toList());
    }
}
