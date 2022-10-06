package lottogame.domain.strategy;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import lottogame.domain.lotto.LottoNumber;

public class RangeLottoNumberPickerStrategy implements LottoNumberGenerationStrategy {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<LottoNumber> getNumbers() {
        List<Integer> fullNumberList = getFullNumberList();
        Collections.shuffle(fullNumberList);

        return fullNumberList.stream()
            .limit(LOTTO_NUMBER_COUNT)
            .map(LottoNumber::new)
            .collect(toList());
    }

    private List<Integer> getFullNumberList() {
        return IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .boxed()
            .collect(toList());
    }
}
