package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberSelector {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final List<Integer> numbers = Stream.iterate(1, i -> i + 1)
        .limit(45)
        .collect(Collectors.toList());

    private LottoNumberSelector() {
    }

    public static List<Integer> selectNumbers() {
        Collections.shuffle(numbers);
        List<Integer> selectedNumbers = numbers.subList(0,6);
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }

}
