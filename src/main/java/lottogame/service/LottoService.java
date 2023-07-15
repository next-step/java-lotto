package lottogame.service;

import lottogame.domain.LottoResult;
import lottogame.domain.LottoShop;
import lottogame.domain.LottoTicket;
import lottogame.domain.WinningLotto;
import lottogame.domain.spi.NumberGenerator;
import lottogame.service.response.LottoCheckResponse;

import java.util.List;
import java.util.Set;

public class LottoService {

    public List<LottoTicket> purchase(int money, NumberGenerator numberGenerator) {
        LottoShop lottoShop = new LottoShop();
        return lottoShop.purchase(money, numberGenerator);
    }

    public LottoCheckResponse checkResult(List<LottoTicket> lottoTickets, Set<Integer> selectedLottoNumbers,
        int bonusLottoNumbers) {
        WinningLotto winningLotto = new WinningLotto(selectedLottoNumbers, bonusLottoNumbers);
        LottoResult lottoResult = new LottoResult(winningLotto.toLottoRanks(lottoTickets));
        return new LottoCheckResponse(lottoResult.getEarningRate(), lottoResult.getLottoRankCounts());
    }
}
