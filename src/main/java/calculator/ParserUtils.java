package calculator;

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


}
