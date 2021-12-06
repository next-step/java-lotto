package step4.domain.generator;

import step4.domain.Lotto;
import step4.domain.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        List<Integer> numberList = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX).boxed()
                .collect(toList());
        Collections.shuffle(numberList);
        return numberList.stream()
                .map(LottoNumber::of)
                .limit(Lotto.SIZE)
                .collect(collectingAndThen(toList(), Lotto::of));
    }
}
