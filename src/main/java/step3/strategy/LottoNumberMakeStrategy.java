package step3.strategy;

import step3.domain.lotto.firstcollection.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberMakeStrategy implements NumberMakeStrategy {
    private static final int LOTTO_RANGE_MAX = 46;
    private static final int START_INCLUSIVE = 1;
    private static final int LOTTO_START_INDEX = 0;
    private static final int LOTTO_END_INDEX = 6;

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>(IntStream.range(START_INCLUSIVE, LOTTO_RANGE_MAX)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList()));


    @Override
    public Set<LottoNumber> create() {
        shuffle();
        return new HashSet<>(lottoNumbers.subList(LOTTO_START_INDEX, LOTTO_END_INDEX));
    }

    private void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

}
