package step1;

import java.util.ArrayList;
import java.util.List;

public class BlankSeparator {

    private static final String BOUND = " ";

    public StringCalculator separateInputText(String inputText) {

        String[] strings = inputText.split(BOUND);

        StringCalculator stringCalculator = new StringCalculator();

        for (String string : strings) {
            stringCalculator.addElement(string);
        }

        return stringCalculator;
    }
}
