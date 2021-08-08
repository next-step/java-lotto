package step4.domain;

public class Shop {
    public static final int LOTTO_PRICE = 1000;

    private Shop() {
    }

    public static Lottos buyLotto(int money) {
        if (!isAvailableMoney(money)) {
            throw new RuntimeException("잘못된 금액을 입력하셨습니다.");
        }

        int count = getLottoCount(money);

        return Lottos.createLottos(count, LOTTO_PRICE * count);
    }

    private static int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private static boolean isAvailableMoney(int money) {
        return money >= 0;
    }
}
