package study.step3.domain;

public class LottoShop {
    private final static int LOTTO_PRICE_PER_PIECE = 1000;
    private final static String LOTTO_PRICE_EXCEPTION = "로또 구매 금액은 1000원 보다 작을 수 없습니다.";

    public static LottoTickets buyLottoTickets(long price) {
        validatePrice(price);
        long lottoCounting = countLottoTicket(price);
        return LottoTickets.publish(lottoCounting);
    }

    private static void validatePrice(long price) {
        if (price < LOTTO_PRICE_PER_PIECE){
            throw new IllegalArgumentException(LOTTO_PRICE_EXCEPTION);
        }
    }

    private static long countLottoTicket(long price) {
        return Math.floorDiv(price, LOTTO_PRICE_PER_PIECE);
    }
}