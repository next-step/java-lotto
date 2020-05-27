package lotto.domain.shop;

public class LottoPurchaseMoney {

    private final static int LOTTO_PRICE = 1000;
    private final static int ZERO_NUMBER = 0;

    private int money;

    private LottoPurchaseMoney(int money) {
        validateMoney(money);
        this.money = money;
    }

    public static LottoPurchaseMoney input(int money) {
        return new LottoPurchaseMoney(money);
    }

    public int getLottoTicketCount() {
        return this.money / LOTTO_PRICE;
    }

    private static void validateMoney(int inputMoney) {
        if (inputMoney <= ZERO_NUMBER) {
            throw new IllegalArgumentException("0원 이하는 로또를 살 수 없습니다.");
        }

        if (inputMoney % LOTTO_PRICE != ZERO_NUMBER) {
            throw new IllegalArgumentException("이 구매기는 거스름돈이 없습니다. 1000원 단위로 입력하세요");
        }
    }
}
