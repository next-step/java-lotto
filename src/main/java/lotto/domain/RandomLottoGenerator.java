package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    private static final int COUNT = 6;

    private static final List<Integer> lottoRange = IntStream.rangeClosed(START_RANGE, END_RANGE)
        .boxed().collect(
            Collectors.toList());

    /**
     * 로또 6자리 생성 로직
     * @return
     */
    @Override
    public  List<LottoNumber> generateLottoNumber() {
        Collections.shuffle(lottoRange);
        List<Integer> subNumbers = lottoRange.stream().limit(COUNT).sorted()
            .collect(Collectors.toList());
        List<LottoNumber>lottoNumbers=subNumbers.stream().map(LottoNumber::new).collect(
            Collectors.toList());
        return lottoNumbers;
    }
}
