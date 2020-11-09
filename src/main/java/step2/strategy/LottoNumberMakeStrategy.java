package step2.strategy;

import step2.Constant;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberMakeStrategy implements NumberMakeStrategy{
    public static final int START_INCLUSIVE = 1;
    public static final int LOTTO_START_INDEX = 0;
    public static final int LOTTO_END_INDEX = 6;

    @Override
    public List<Integer> create() {
        List<Integer> lottoRange = IntStream.range(START_INCLUSIVE, Constant.LOTTO_RANGE_MAX)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoRange);
        return lottoRange.subList(LOTTO_START_INDEX, LOTTO_END_INDEX);
    }
}
