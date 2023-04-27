package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberCreation implements NumberCreationStrategy {

    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    @Override
    public List<Integer> createNumber() {
        List<Integer> number =
                IntStream.rangeClosed(LOTTO_FIRST_NUMBER, LOTTO_LAST_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(number);
        List<Integer> sortedNumber = number.subList(0, LottoNumber.LOTTO_SIZE);
        Collections.sort(sortedNumber);
        return sortedNumber;
    }
}
