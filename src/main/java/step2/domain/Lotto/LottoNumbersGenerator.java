package step2.domain.Lotto;

public final class LottoNumbersGenerator {

    private static LottoNumbersGenerator instance;

    private LottoNumbersGenerator() {}

    public static final LottoNumbersGenerator getInstance() {
        if(isInstanceNull()) {
            instance = new LottoNumbersGenerator();
        }
        return instance;
    }

    private static final boolean isInstanceNull() {
        return instance == null;
    }
}
