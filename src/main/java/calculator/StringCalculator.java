package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private TextStorage separation(String text) {
        TextStorage storage = new TextStorage(text);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(storage.getText());
        if (m.find()) {
            storage = new TextStorage(m.group(2), m.group(1));
        }
        return storage;
    }

    public int add(String text) {
        TextStorage storage = separation(text);

        String[] tokens = storage.getText().split(storage.getSeparator());

        if (Arrays.stream(tokens).map(Integer::parseInt).anyMatch(integer -> integer < 0)) {  // 하나라도 -1 이하면
            throw new RuntimeException();
        }
        return Arrays.stream(tokens).map(Integer::parseInt).reduce(0, Integer::sum);
    }

}
