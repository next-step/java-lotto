package domain;

import java.util.List;

public class LottoUtil {

    private LottoUtil(){    
        throw new AssertionError();
    };
    
    public static Integer stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw e;
        }
    }

    public static List<String> stringSplitToList(String input) {
        return List.of(input.split(",")).stream()
                .map(String::trim)
                .toList();
    }
}
