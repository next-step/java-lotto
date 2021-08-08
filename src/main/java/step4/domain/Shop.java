package step4.domain;

import step4.validator.LottoValidator;

import java.util.List;

public class Shop {
    public static final int LOTTO_PRICE = 1000;

    private Shop() {
    }

    public static Lottos buyLotto(int money) {
        LottoValidator.validateMoney(money);

        int count = getLottoCount(money);

        return Lottos.createLottos(count, LOTTO_PRICE * count);
    }

    public static Lottos buyLotto(int money, List<List<Integer>> manualLottoNums) {
        LottoValidator.validateMoney(money);

        int count = getLottoCount(money) - manualLottoNums.size();
        LottoValidator.validateManualCount(count);

        return Lottos.createLottos(count, manualLottoNums, LOTTO_PRICE * count);
    }

    private static int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
