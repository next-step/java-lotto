package autolotto.domain;

public class Ticket {
    private static final int LOTTO_PRICE = 1000;

    private int buyAmt;

    public Ticket(int buyAmt) {
        this.buyAmt = buyAmt;
        isLowLottoPrice();
    }

    public int toTicketCount() {
        return buyAmt / LOTTO_PRICE;
    }

    private void isLowLottoPrice() {
        if (buyAmt < LOTTO_PRICE) {
            throw new IllegalArgumentException("1천원 미만으로 입력하셨습니다. 로또는 1장에 1천원 입니다.");
        }
    }
}
