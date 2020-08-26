package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<LottoNumber> LOTTO_NUMBER_POOL;
    private List<LottoNumber> lottoNumbers;

    static {
        LOTTO_NUMBER_POOL = Stream.iterate(LOTTO_START_NUMBER, number -> number + 1)
                .limit(LOTTO_END_NUMBER)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket create(int count) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.add(makeOneLine());
        }
        return new LottoTicket(lottoNumbers);
    }

    private static LottoNumbers makeOneLine() {
        Collections.shuffle(LOTTO_NUMBER_POOL);
        List<LottoNumber> lottoNumbers =
                LOTTO_NUMBER_POOL
                        .stream()
                        .limit(LOTTO_NUMBER_COUNT)
                        .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }
}
