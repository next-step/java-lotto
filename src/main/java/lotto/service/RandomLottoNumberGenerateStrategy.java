package lotto.util;

import lotto.vo.LottoRule;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerateStrategy implements NumberGenerateStrategy {

    @Override
    public List<Integer> generate() {
        List<Integer> numberList = IntStream.rangeClosed(LottoRule.START_NUMBER.getValue(), LottoRule.END_NUMBER.getValue()).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numberList);
        return numberList.stream()
                .limit(LottoRule.LOTTO_COUNT.getValue())
                .collect(Collectors.toList());
    }
}
