package lotto.domain;

public interface LottoTicketMaker {
    int DEFAULT_LOTTO_NUMBER_COUNT = 6;

    LottoTicket create();
}
