package step3.strategy;

import step3.domain.lotto.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step3.Constant.*;

public class LottoNumberMakeStrategy implements NumberMakeStrategy {
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
