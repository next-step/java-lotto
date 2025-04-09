package lotto.domain.service;

import lotto.domain.generator.LottoTicketGenerator;
import lotto.domain.generator.StaticLottoTicketGenerator;
import lotto.domain.model.LottoTicket;

import java.util.ArrayList;
import java.util.List;


public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final LottoTicketGenerator lottoTicketGenerator;
    private int purchaseAmount = 0;

    public LottoMachine(LottoTicketGenerator lottoTicketGenerator, int purchaseAmount) {
        this.lottoTicketGenerator = lottoTicketGenerator;
        this.purchaseAmount = purchaseAmount;
    }

    public List<LottoTicket> buyManualLottos(List<List<Integer>> manualNumbersList) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (List<Integer> manualNumbers : manualNumbersList) {
            LottoTicketGenerator lottoTicketGenerator = new StaticLottoTicketGenerator(manualNumbers);
            LottoTicket lotto = lottoTicketGenerator.generate();
            lottoTickets.add(lotto);
        }
        this.purchaseAmount -= LOTTO_PRICE * manualNumbersList.size();
        return lottoTickets;
    }

    public List<LottoTicket> buyAutomaticLottos() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        int numLottos = this.purchaseAmount / LOTTO_PRICE;
        for (int i = 0; i < numLottos; i++) {
            LottoTicket lotto = this.lottoTicketGenerator.generate();
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }
}
