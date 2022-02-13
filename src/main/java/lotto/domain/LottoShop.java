package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;
    private static final String MIN_PURCHASE_EXCEPTION_MESSAGE = "최소 1000원이어야 합니다.";
    private static final LottoShop INSTANCE = new LottoShop();

    private LottoShop() {
    }

    public static LottoShop getInstance() {
        return INSTANCE;
    }

    public int countPossibleLottoAmount(final Money money) {
        validatePrice(money);
        return money.divideByLottoPrice();
    }

    private void validatePrice(final Money money) {
        if (money.getMoney() < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_PURCHASE_EXCEPTION_MESSAGE);
        }
    }

    public void buyHandOperatedLotto(final Lottos lottos, final String[] lottoNumbers) {
        lottos.storeLotto(
            new Lotto(Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList())));
    }

    public void buyAutoLotto(final Lottos lottos, final int lottoAmount) {
        for (int amount = ZERO; amount < lottoAmount; amount++) {
            lottos.storeLotto(new Lotto());
        }
    }

}
