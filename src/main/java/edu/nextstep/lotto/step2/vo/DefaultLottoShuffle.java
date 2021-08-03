package edu.nextstep.lotto.step2.vo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoShuffle implements LottoShuffle {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MAX_COUNT = 6;

    @Override
    public List<Integer> shuffle() {
        List<Integer> fullLottoNumbers = IntStream.range(1, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(fullLottoNumbers);

        List<Integer> lottoNumbers = fullLottoNumbers.subList(0, LOTTO_MAX_COUNT);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
