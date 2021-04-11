package lotto.domain;

public class LottoTicketPrice {

    private static final int STANDARD_PRICE = 1_000;
    private final int lottoTicketPrice;

    public LottoTicketPrice() {
        this(STANDARD_PRICE);
    }

    public LottoTicketPrice(int price) {
        this.lottoTicketPrice = price;
    }

    public int divide(int purchaseAmount) {
        return purchaseAmount / lottoTicketPrice;
    }
    public int price() {
        return lottoTicketPrice;
    }

}
