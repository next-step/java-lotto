package step2.domain.Lotto;

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
}
