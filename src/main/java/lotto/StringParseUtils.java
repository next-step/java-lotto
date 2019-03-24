package lotto;

import java.util.ArrayList;
import java.util.List;

public class StringParseUtils {

    public static List<Integer> parseToIntegerList(String inputNumber) {
        List<Integer> winningNumber = new ArrayList<>();

        String[] split = inputNumber.trim().split(",");
        for (String str : split) {
            winningNumber.add(Integer.parseInt(str.trim()));
        }
        return winningNumber;
    }
}
