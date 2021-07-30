package step2.domain;

public class Shop {
    public static final int LOTTO_PRICE = 1000;

    public static Lottos buyLotto(int money) {
        if (!isAvailableMoney(money)) throw new RuntimeException("잘못된 금액을 입력하셨습니다.");

        return Lottos.createLottos(getLottoCount(money), LOTTO_PRICE);
    }

    private static int getLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    private static boolean isAvailableMoney(int money) {
        return money >= 0;
    }
}
