package lotto.domain;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    public static final String MIN_PURCHASE_EXCEPTION_MESSAGE = "최소 1000원이어야 합니다.";
    public static final String PER_THOUSAND_EXCEPTION_MESSAGE = "투입한 금액이 1000원 단위가 아닙니다.";

    private int lottoAmount = ZERO;

    public int countPossibleLottoAmount(final int price) {
        validatePrice(price);
        lottoAmount = price / LOTTO_PRICE;
        return lottoAmount;
    }

    private void validatePrice(final int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_PURCHASE_EXCEPTION_MESSAGE);
        }
        if (price % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(PER_THOUSAND_EXCEPTION_MESSAGE);
        }
    }

    public Lottos buyLotto() {
        Lottos lottos = new Lottos();
        for (int amount = ZERO; amount < lottoAmount; amount++) {
            lottos.storeLotto(new Lotto());
        }
        return lottos;
    }

}
