package study.lotto.domain;

@FunctionalInterface
public interface LottoTicketIssuer {
    LottoTicket issue();
}
