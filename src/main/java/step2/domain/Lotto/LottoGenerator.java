package step2.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoGenerator {
    private static final int START = 1;
    private static final int LIMIT = 46;

    private static LottoGenerator instance;

    private LottoGenerator() {}

    public static final LottoGenerator getInstance() {
        if(isInstanceNull()) {
            instance = new LottoGenerator();
        }
        return instance;
    }

    private static final boolean isInstanceNull() {
        return instance == null;
    }

    public final Lotto generateLotto() {
        LottoNumbers lottoNumbers = generateLottoNumbers();
        return Lotto.newInstance(lottoNumbers.subLottoNumbers(0, 6));
    }

    private final LottoNumbers generateLottoNumbers() {
        return LottoNumbers.newInstance(generateLottoNumberList());
    }

    private final List<LottoNumber> generateLottoNumberList() {
        return IntStream.range(START, LIMIT)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }


}
