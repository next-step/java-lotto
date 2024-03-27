package lotto.domain.lottoStrategy;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.END_INCLUSIVE;
import static lotto.domain.LottoNumber.START_INCLUSIVE;

public class RandomLottoStrategy implements LottoGenerateStrategy{

    private static final int FROM_INDEX = 0;
    private static final int LAST_INDEX = 6;

    private final List<Integer> lottoNumberPool;

    public RandomLottoStrategy() {
        this.lottoNumberPool = IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public Lotto generateLotto(int i) {
        Collections.shuffle(lottoNumberPool);
        List<Integer> pickLottoNumbers = new ArrayList<>(lottoNumberPool.subList(FROM_INDEX, LAST_INDEX));
        Collections.sort(pickLottoNumbers);
        return new Lotto(pickLottoNumbers);
    }
}
