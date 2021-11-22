package lotto.domain;

import lotto.vo.LottoNumber;
import lotto.vo.LottoRule;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        List<Integer> numberList = IntStream.rangeClosed(LottoRule.START_NUMBER.getValue(), LottoRule.END_NUMBER.getValue()).boxed()
                .collect(toList());
        Collections.shuffle(numberList);
        return numberList.stream()
                .map(LottoNumber::create)
                .limit(LottoRule.LOTTO_COUNT.getValue())
                .collect(collectingAndThen(toList(), Lotto::create));
    }
}
