package step4.domain;

import java.util.List;

public class Shop {
    public static final int LOTTO_PRICE = 1000;

    private Shop() {
    }

    public static Lottos buyLotto(int money) {
        validateMoney(money);

        int count = getLottoCount(money);

        return Lottos.createLottos(count, LOTTO_PRICE * count);
    }

    public static Lottos buyLotto(int money, List<List<Integer>> manualLottoNums) {
        validateMoney(money);

        int count = getLottoCount(money) - manualLottoNums.size();
        validateManualCount(count);

        return Lottos.createLottos(count, manualLottoNums, LOTTO_PRICE * count);
    }

    private static void validateMoney(int money) {
        if (isNotAvailableMoney(money)) {
            throw new RuntimeException("잘못된 금액을 입력하셨습니다.");
        }
    }

    private static boolean isNotAvailableMoney(int money) {
        return money < 0;
    }

    public static void validateManualCount(int count) {
        if (isLottoCountNotAvailable(count)) {
            throw new RuntimeException("구매한 금액보다 더 많은 수동 로또를 입력하였습니다.");
        }
    }

    private static boolean isLottoCountNotAvailable(int count) {
        return count < 0;
    }

    private static int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }
}
