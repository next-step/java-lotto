package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class SplitUtil {

    private SplitUtil() {
    }

    public static List<Integer> fromStringToList(String input) {
        String[] inputArray = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : inputArray) {
            numbers.add(Integer.parseInt(s.trim()));
        }
        return numbers;
    }

}
