package lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.Constants.MAX_NUMBER;
import static lotto.constants.Constants.MIN_NUMBER;
import static lotto.constants.Constants.REQUIRED_LOTTO_NUMBERS;
import static lotto.constants.Constants.ZERO;

public class AutoLotto implements LottoStrategy {

    @Override
    public List<Integer> generateNumbers() {
        List<Integer> lottoNumbers = createRandomNumberList();
        Collections.sort(lottoNumbers);
        return new ArrayList<>(lottoNumbers);
    }

    private List<Integer> createRandomNumberList() {
        List<Integer> numberList = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numberList);
        return numberList.subList(ZERO, REQUIRED_LOTTO_NUMBERS);
    }

}
