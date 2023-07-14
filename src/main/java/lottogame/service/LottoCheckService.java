package lottogame.service;

import java.util.List;
import java.util.Set;

import lottogame.domain.LottoResult;
import lottogame.domain.WinningLotto;
import lottogame.domain.LottoTicket;
import lottogame.service.response.LottoCheckResponse;

public class LottoCheckService {

    public LottoCheckResponse checkResult(List<LottoTicket> lottoTickets, Set<Integer> selectedLottoNumbers,
        int bonusLottoNumbers) {
        WinningLotto winningLotto = new WinningLotto(selectedLottoNumbers, bonusLottoNumbers);
        LottoResult lottoResult = new LottoResult(winningLotto.toLottoPrizes(lottoTickets));
        return new LottoCheckResponse(lottoResult.getEarningRate(), lottoResult.getLottoPrizeCounts());
    }
}
