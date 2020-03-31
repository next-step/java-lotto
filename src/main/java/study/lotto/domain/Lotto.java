package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoTicket> lottoTickets;
    private LottoTicketIssuer lottoTicketIssuer;
    private Amount investmentAmount;

    public Lotto(Amount amount, LottoTicketIssuer lottoTicketIssuer) {
        this.lottoTicketIssuer = lottoTicketIssuer;
        generateLottoTicket(amount);
    }

    public Lotto(int amount, LottoTicketIssuer lottoTicketIssuer) {
        this(new Amount(amount), lottoTicketIssuer);
    }

    private void generateLottoTicket(Amount amount) {
        int quantity = amount.getAmount() / LottoTicket.PRICE;

        investmentAmount = new Amount(quantity * LottoTicket.PRICE);
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(lottoTicketIssuer.issue());
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets.stream()
                .map(LottoTicket::new)
                .collect(Collectors.toList());
    }

    public LottoResult result(LottoWinningNumber lottoWinningNumber) {
        return new LottoResult(lottoTickets,
                lottoWinningNumber,
                investmentAmount);
    }
}
