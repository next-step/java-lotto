package lotto.domain.shop.exceptions;

public class ExceedTotalLottoTicketsCountInMoney extends RuntimeException {
    public ExceedTotalLottoTicketsCountInMoney(String message) {
        super(message);
    }
}
