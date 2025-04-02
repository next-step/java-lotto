package lotto.domain.strategy;

import lotto.domain.model.lotto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGeneratorStrategy implements LottoNumberGeneratorStrategy {

    private final List<LottoNumber> lottoNumberPool;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public RandomLottoNumberGeneratorStrategy(){
        lottoNumberPool = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public Set<LottoNumber> generate() {
        Collections.shuffle(lottoNumberPool);

        return new TreeSet<>(lottoNumberPool.subList(0, LOTTO_NUMBER_SIZE));
    }
}
