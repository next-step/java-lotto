package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumberRandomSelector implements LottoNumberSelectPolicy {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> numbers = Stream.iterate(1, i -> i + 1)
        .limit(45)
        .collect(Collectors.toList());

    @Override
    public List<Integer> selectNumbers() {
        Collections.shuffle(numbers);
        List<Integer> selectedNumbers = numbers.subList(0, LOTTO_NUMBER_SIZE);
        Collections.sort(selectedNumbers);
        return selectedNumbers;
    }

}
