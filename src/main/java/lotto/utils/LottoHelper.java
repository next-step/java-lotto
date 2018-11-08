package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoHelper {
    public static List<Integer> convertToList(String winningNumber) {
        return Arrays.stream(winningNumber.split(","))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
}
