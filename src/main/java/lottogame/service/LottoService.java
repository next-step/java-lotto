package lottogame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lottogame.domain.LottoResult;
import lottogame.domain.WinningLotto;
import lottogame.domain.LottoTicket;
import lottogame.domain.spi.NumberGenerator;
import lottogame.service.response.LottoCheckResponse;

public class LottoService {

    public List<LottoTicket> purchase(int money, NumberGenerator numberGenerator) {
        assertMoney(money);
        return createLottoTickets(money, numberGenerator);
    }

    private void assertMoney(int money) {
        if (money % LottoTicket.PURCHASABLE_UNIT != 0) {
            throw new IllegalArgumentException(
                    String.format("money는 \"%d\"원으로 나누어 떨어져야 합니다 money: \"%d\"", LottoTicket.PURCHASABLE_UNIT, money));
        }
    }

    private List<LottoTicket> createLottoTickets(int money, NumberGenerator numberGenerator) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int count = 0; count < money / LottoTicket.PURCHASABLE_UNIT; count++) {
            lottoTicketList.add(new LottoTicket(numberGenerator));
        }
        return lottoTicketList;
    }

    public LottoCheckResponse checkResult(List<LottoTicket> lottoTickets, Set<Integer> selectedLottoNumbers,
        int bonusLottoNumbers) {
        WinningLotto winningLotto = new WinningLotto(selectedLottoNumbers, bonusLottoNumbers);
        LottoResult lottoResult = new LottoResult(winningLotto.toLottoRanks(lottoTickets));
        return new LottoCheckResponse(lottoResult.getEarningRate(), lottoResult.getLottoRankCounts());
    }
}
