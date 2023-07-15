package lottogame.service;

import lottogame.domain.LottoResult;
import lottogame.domain.LottoTicket;
import lottogame.domain.WinningLotto;
import lottogame.service.response.LottoCheckResponse;

import java.util.List;
import java.util.Set;

public class LottoService {

    public LottoCheckResponse checkResult(List<LottoTicket> lottoTickets, Set<Integer> selectedLottoNumbers,
        int bonusLottoNumbers) {
        WinningLotto winningLotto = new WinningLotto(selectedLottoNumbers, bonusLottoNumbers);
        LottoResult lottoResult = new LottoResult(winningLotto.toLottoRanks(lottoTickets));
        return new LottoCheckResponse(lottoResult.getEarningRate(), lottoResult.getLottoRankCounts());
    }
}
