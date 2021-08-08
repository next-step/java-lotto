package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    @Override
    public LottoTicket generate() {
        List<LottoNumber> targetNumbers = shuffleLottoNumbers();
        return pickLottoNumbers(targetNumbers);
    }

    private List<LottoNumber> shuffleLottoNumbers() {
        List<LottoNumber> targetNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(targetNumbers);
        return targetNumbers;
    }

    private LottoTicket pickLottoNumbers(List<LottoNumber> targetNumbers) {
        List<LottoNumber> lottoNumbers = targetNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted()
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}
