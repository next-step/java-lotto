package lottogame.domain.strategy;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import lottogame.domain.lotto.LottoNumber;
import lottogame.domain.lotto.LottoNumbers;

public class RangeLottoNumberPickerStrategy implements LottoNumberGenerationStrategy {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @Override
    public LottoNumbers getNumbers() {
        List<Integer> fullNumberList = getFullNumberList();
        Collections.shuffle(fullNumberList);

        List<LottoNumber> lottoNumbers = fullNumberList.stream()
            .limit(LOTTO_NUMBER_COUNT)
            .map(LottoNumber::new)
            .collect(toList());

        return new LottoNumbers(lottoNumbers);
    }

    private List<Integer> getFullNumberList() {
        return IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .boxed()
            .collect(toList());
    }
}
