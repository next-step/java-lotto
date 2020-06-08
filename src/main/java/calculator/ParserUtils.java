package calculator;

import java.util.ArrayList;
import java.util.List;

public class ParserUtils {

    public boolean checkEmpty(String input) {

        if (input.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkNull(String input) {

        if (input == null) {
            return false;
        }
        return true;
    }

    public List stringToArray(String input) {

        List result = new ArrayList();
        String[] splitText = input.split(",");

        for (String text: splitText) {
            result.add(Integer.parseInt(text));
        }

        return result;
    }
}
