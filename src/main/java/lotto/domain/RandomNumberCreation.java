package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberCreation implements NumberCreationStrategy {

    private static final List<Integer> number =
            IntStream.rangeClosed(LottoNumber.LOTTO_FIRST_NUMBER,
                                    LottoNumber.LOTTO_LAST_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());

    @Override
    public List<Integer> createNumber() {
        Collections.shuffle(number);
        List<Integer> sortedNumber = number.subList(0, LottoTicket.LOTTO_SIZE);
        Collections.sort(sortedNumber);
        return sortedNumber;
    }
}
