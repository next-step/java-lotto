package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLottoGenerator implements LottoGeneratorStrategy {
    public static final int LOTTO_TOTAL_COUNT = 45;
    public static final int LOTTO_MIN_SIZE = 0;
    public static final int LOTTO_MAX_SIZE = 6;

    @Override
    public List<Integer> generateLotto() {
        List<Integer> lottoAllNum = Stream.iterate(1, n -> n + 1).limit(LOTTO_TOTAL_COUNT).collect(Collectors.toList());
        Collections.shuffle(lottoAllNum);
        List<Integer> lottoNumbers = lottoAllNum.subList(LOTTO_MIN_SIZE, LOTTO_MAX_SIZE);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
