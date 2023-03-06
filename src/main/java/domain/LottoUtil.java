package domain;

import java.util.List;

public class LottoUtil {
    public static Integer stringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static List<String> stringSplitToList(String input) {
        return List.of(input.split(",")).stream()
                .map(String::trim)
                .toList();
    }
}
