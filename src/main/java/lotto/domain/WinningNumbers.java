package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final String SEPARATOR = ", ";

    private List<Integer> list;

    public WinningNumbers(List<Integer> list) {
        this.list = list;
    }

    public static List<Integer> createList(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(SEPARATOR))
                    .mapToInt(x -> Integer.parseInt(x))
                    .boxed()
                    .collect(Collectors.toList());
    }

    public List<Integer> getList() {
        return Collections.unmodifiableList(list);
    }
}
