package step2.strategy;

import step2.Constant;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberMakeStrategy implements NumberMakeStrategy{
    @Override
    public List<Integer> create() {
        List<Integer> lottoRange = IntStream.range(0, Constant.LOTTO_RANGE_MAX)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoRange);
        return lottoRange.subList(0, 6);
    }
}
