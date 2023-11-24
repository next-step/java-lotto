package step2.lotto.domain;

public class LottoPurchase {

    private final int lottoPurchaseMoney;
    private final int lottoTicketCount;

    private static final int LOTTO_PRICE = 1000;

    public LottoPurchase(final int inputMoney) {
        validateInputMoney(inputMoney);
        this.lottoPurchaseMoney = inputMoney;
        this.lottoTicketCount = inputMoney / LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    public int getLottoPurchaseMoney() {
        return lottoPurchaseMoney;
    }

    private void validateInputMoney(final int inputMoney) {
        if (inputMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구입 최소금액은 " + LOTTO_PRICE + "원 입니다.");
        }
    }
}
