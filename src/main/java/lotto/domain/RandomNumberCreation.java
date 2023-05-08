package lotto.domain;

import java.util.ArrayList;
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

    private int creationCount;

    public RandomNumberCreation(int creationCount) {
        this.creationCount = creationCount;
    }

    @Override
    public List<List<Integer>> getNumbers() {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0 ; i < creationCount; i++) {
            Collections.shuffle(number);
            List<Integer> sortedNumber =
                    new ArrayList<>(number.subList(0, LottoTicket.LOTTO_SIZE));
            Collections.sort(sortedNumber);
            result.add(sortedNumber);
        }
        return result;
    }
}
