package lotto;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Integer> parseToIntegerList(String inputNumber) {
        List<Integer> winningNumber = new ArrayList<>();

        String[] split = inputNumber.trim().split(",");
        for (String str : split) {
            winningNumber.add(Integer.parseInt(str));
        }
        return winningNumber;
    }
}
