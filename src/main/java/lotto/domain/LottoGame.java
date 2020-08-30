package lotto.domain;

public class LottoGame {
    public static final Integer DEFAULT_LOTTO_PRICE = 1_000;
    private static final Integer INTEGER_ONE = 1;
    private static final String INVALID_LOTTO_PURCHASE_AMOUNT = "로또 구입 금액이 부족합니다.";

    private final int amount;

    private LottoGame(int amount) {
        this.amount = amount;
    }

    public static LottoGame of(int amount) {
        int count = amount / DEFAULT_LOTTO_PRICE;
        validate(count);

        return new LottoGame(amount);
    }

    public static void validate(int count) {
        if(count < INTEGER_ONE) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_AMOUNT);
        }
    }

    public int getCount() {
        return amount / DEFAULT_LOTTO_PRICE;
    }

    public Lottos makeLottos(LottoNumberRandomGenerator lottoNumberRandomGenerator) {
        return Lottos.of(getCount(), lottoNumberRandomGenerator);
    }
}