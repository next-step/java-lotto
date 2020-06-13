package lotto.model;

public class Payment {

    public static final int LOTTO_PRICE = 1000;
    public static final int ZERO = 0;

    private int money;
    private int countOfManualLottoTicket;

    private Payment(int money, int countOfManualLottoTicket) {
        this.money = money;
        this.countOfManualLottoTicket = countOfManualLottoTicket;
    }

    public static Payment of(int money, int countOfManualLottoTicket) {
        validateMoney(money);

        return new Payment(money, countOfManualLottoTicket);
    }

    private static void validateMoney(int money) {
        if (money <= ZERO) {
            throw new IllegalArgumentException("금액은 0 이상의 값으로 입력해주세요.");
        }

        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또의 금액은 " + LOTTO_PRICE + " 원 입니다." + LOTTO_PRICE + "원 이상의 금액을 입력해주세요.");
        }
    }

    public int getCountOfTotalLottoTicket() {
        int countOfTotalLottoTicket = getCountOfAutomaticLottoTicket() - getCountOfManualLottoTicket();

        validateCountOfLottoTicket(countOfTotalLottoTicket);

        return countOfTotalLottoTicket;
    }

    private int getCountOfAutomaticLottoTicket() {
        return money / LOTTO_PRICE;
    }

    private int getCountOfManualLottoTicket() {
        return countOfManualLottoTicket;
    }

    private void validateCountOfLottoTicket(int countOfTotalLottoTicket) {
        if (countOfTotalLottoTicket < ZERO) {
            throw new IllegalArgumentException("구매 금액보다 수동으로 구매할 로또의 수가 많습니다. 금액을 확인해 주세요.");
        }
    }
}
