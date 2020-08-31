package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLottoGenerator implements LottoGeneratorStrategy {
    private static final int LOTTO_TOTAL_COUNT = 45;
    private static final int LOTTO_MIN_SIZE = 0;
    private static final int LOTTO_MAX_SIZE = 6;
    static List<Integer> lottoAllNum = Stream.iterate(1, n -> n + 1).limit(LOTTO_TOTAL_COUNT).collect(Collectors.toList());

    @Override
    public List<Integer> generateLotto() {
        Collections.shuffle(lottoAllNum);
        List<Integer> lottoNumbers = Stream.iterate(LOTTO_MIN_SIZE, n -> n + 1)
                .limit(LOTTO_MAX_SIZE)
                .map(n -> lottoAllNum.get(n))
                .collect(Collectors.toList());
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
