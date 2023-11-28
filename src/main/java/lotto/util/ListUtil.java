package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {

    public static List<Integer> parseIntegerList(List<String> winningNumList) {

        return winningNumList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
