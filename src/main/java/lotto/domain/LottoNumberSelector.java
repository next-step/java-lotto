package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberSelector {

    private static final Integer LOTTO_NUMBER_SIZE = 6;
    private static final List<Integer> numbers = Stream.iterate(1, i -> i + 1)
        .limit(45)
        .collect(Collectors.toList());

    public static List<Integer> selectNumbers() {
        List<Integer> selectedNumbers = new ArrayList<>();
        Collections.shuffle(numbers);
        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            selectedNumbers.add(numbers.get(i));
        }
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }

}
