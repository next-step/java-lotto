package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    public static List<Integer> get(String number) {
        String[] numberArray = number.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : numberArray) {
            numbers.add(Integer.parseInt(stringNumber));
        }
        return numbers;
    }
}
