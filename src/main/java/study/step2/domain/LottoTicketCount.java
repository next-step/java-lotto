package study.step2.domain;

public class LottoTicketCount {
    private static final int ONE_LOTTO_PRICE = 1000;

    private LottoTicketCount() {}

    public static int calculateTicketCount(int price){
        return price/ONE_LOTTO_PRICE;
    }
}