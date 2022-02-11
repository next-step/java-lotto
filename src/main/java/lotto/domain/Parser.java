package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    
    public static List<Integer> parseWinningNumber(String numbersString) {
        numbersString = numbersString.replace(" ", "");
        String[] numberStringList = numbersString.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : numberStringList) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }
}
