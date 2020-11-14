import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int sum(String text) {
        if(checkNullString(text) || checkEmptyString(text)) {
            return 0;
        }

        if(checkOnlyOneText(text)) {
            return Integer.parseInt(text);
        }

        return 0;
    }

    private boolean checkOnlyOneText(String text) {
        Matcher m = Pattern.compile("^[0-9]+$").matcher(text);
        return m.find();
    }

    private boolean checkEmptyString(String text) {
        return text.isEmpty();
    }

    private boolean checkNullString(String text) {
        return text == null;
    }

}
