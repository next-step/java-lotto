package lotto.domain;

public class LottoPrice {
    private final int price = 1000;

    public int lottoTicketNumber(int receiveMoney) {
        return receiveMoney / price;
    }
}
