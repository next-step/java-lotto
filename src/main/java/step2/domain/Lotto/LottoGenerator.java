package step2.domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoGenerator {

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


    private final LottoNumbers generateLottoNumbers() {
        return LottoNumbers.newInstance(generateLottoNumberList());
    }

    private final List<LottoNumber> generateLottoNumberList() {
        return IntStream.range(1, 46)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

}
