package lotto.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputParser {
    private LottoInputParser() {}

    public static List<Integer> parseToIntegers(String input){
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
