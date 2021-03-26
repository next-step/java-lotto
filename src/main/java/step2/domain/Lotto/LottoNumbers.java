package step2.domain.Lotto;

import step2.exception.ListNullPointerException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(int start, int end) {
        this(generateLottoNumbers(start, end));
    }

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        if (isListNull(lottoNumbers)) {
            throw new ListNullPointerException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    private static final List<LottoNumber> generateLottoNumbers(int start, int end) {
        return IntStream
                .range(start, end)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public final static LottoNumbers newInstance(List<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public final static LottoNumbers newInstance(int start, int end) {
        return new LottoNumbers(start, end);
    }


    private final boolean isListNull(List<LottoNumber> lottoNumbers) {
        return lottoNumbers == null;
    }
}
