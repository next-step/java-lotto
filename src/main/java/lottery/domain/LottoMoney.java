package lottery.domain;

public class LottoMoney {

    private static final String ILLEGAL_MONEY = "구매 금액은 0보다 커야 합니다.";
    private static final String NOT_ENOUGH_MONEY = "로또 구입 금액이 부족합니다.";
    private final int lottoMoney;

    public LottoMoney(int purchaseAmount) {
        this.lottoMoney = checkAmount(purchaseAmount);
    }

    private int checkAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(ILLEGAL_MONEY);
        }

        return purchaseAmount;
    }

    public int getNumberOfTickets() {
        int numberOfTickets = this.lottoMoney / LottoTicket.TICKET_PRICE;
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY);
        }
        return numberOfTickets;
    }
}
