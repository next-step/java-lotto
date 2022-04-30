package lotto.controller;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;

public class LottoGameController {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public LottoTickets createLottoTickets(int buyingBudget) {
        int buyingCount = buyingBudget / LOTTO_TICKET_PRICE;

        LottoTickets lottoTickets = new LottoTickets();
        while (buyingCount-- > 0) {
            lottoTickets.add();
        }

        return lottoTickets;
    }

    public LottoResults analysisResult(LottoTickets lottoTickets, List<Integer> winLottoNumber, int bonusNumber) {
        return new LottoResults(lottoTickets.findLottoResult(winLottoNumber, bonusNumber));
    }
}
