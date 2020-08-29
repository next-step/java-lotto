package lotto.domain;

public class LottoGame {
    private static final Integer DEFAULT_LOTTO_PRICE = 1000;
    private static final Integer INTEGER_ONE = 1;
    private static final String INVALID_LOTTO_PURCHASE_AMOUNT = "로또 구입 금액이 부족합니다.";

    private final int count;

    private LottoGame(int count) {
        this.count = count;
    }

    public static LottoGame of(int purchaseAmount) {
        int count = purchaseAmount / DEFAULT_LOTTO_PRICE;
        validate(count);

        return new LottoGame(count);
    }

    public static void validate(int count) {
        if(count < INTEGER_ONE) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_AMOUNT);
        }
    }

    public int getCount() {
        return count;
    }

    public Lottos makeLottos(LottoNumberRandomGenerator lottoNumberRandomGenerator) {
        return Lottos.of(count, lottoNumberRandomGenerator);
    }
}