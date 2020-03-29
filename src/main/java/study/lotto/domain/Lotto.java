package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private List<LottoTicket> lottoTickets;
    private LottoTicketIssuer lottoTicketIssuer;
    private int investmentAmount;

    public Lotto(int amount, LottoTicketIssuer lottoTicketIssuer) {
        this.lottoTicketIssuer = lottoTicketIssuer;
        generateLottoTicket(amount);
    }

    private void generateLottoTicket(int amount) {
        int quantity = amount / LottoTicket.PRICE;

        if (quantity < 0) {
            quantity = 0;
        }

        investmentAmount = quantity * LottoTicket.PRICE;
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(lottoTicketIssuer.issue());
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets.stream()
                .map(LottoTicket::clone)
                .collect(Collectors.toList());
    }

    public LottoResult setWinningNumber(LottoWinningNumber winningNumber) {
        LottoResult lottoResult = new LottoResult(investmentAmount);

        for (LottoTicket lottoTicket : lottoTickets) {
            LottoRank lottoRank = LottoRule.getWinningRank(lottoTicket,
                    winningNumber);
            // todo refactor
            if (lottoRank != null) {
                lottoResult.addWinningTicket(lottoRank, lottoTicket);
            }
        }

        return lottoResult;
    }
}
