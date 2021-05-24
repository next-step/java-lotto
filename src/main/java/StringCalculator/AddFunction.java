package StringCalculator;

import java.util.List;

public class AddFunction {
    StringCalculator stringCalculator = new StringCalculator();

    public int add(String text) {
        String newText = stringCalculator.isEmptyText(text);
        List<String> splitText = stringCalculator.splitText(newText);
        int result = 0;

        for (String number : splitText) {
            result += Integer.parseInt(number);
        }

        return result;
    }
}