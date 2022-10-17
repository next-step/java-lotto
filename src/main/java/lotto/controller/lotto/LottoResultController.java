package lotto.controller.lotto;

import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;
import lotto.service.LottoResultService;
import lotto.domain.*;
import lotto.domain.lotto.*;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.List;
import java.util.Map;

public class LottoResultController {

    private final LottoResultService lottoResultService;

    public LottoResultController(final LottoResultService lottoResultService) {
        this.lottoResultService = lottoResultService;
    }

    public void draw(final List<Lotto> lottos) {
        lottoResult(lottos, drawWinner());
    }

    private LottoWinner drawWinner() {
        LottoOutput.winningNumber();
        LottoNumberSet numbers = LottoInput.lottoNumbers();

        LottoOutput.bonusNumber();
        LottoNumber bonusNumber = LottoInput.bonusNumber();

        return new LottoWinner(numbers, bonusNumber);
    }

    private void lottoResult(final List<Lotto> lottos, final LottoWinner winner) {
        Map<Rank, Amount> checkLotto = lottoResultService.checkLotto(lottos, winner);
        LottoOutput.statistics();
        for (int rankIndex = Rank.REWARD_START_RANK_INDEX; rankIndex >= Rank.REWARD_END_RANK_INDEX; rankIndex--) {
            Rank rank = Rank.values()[rankIndex];
            lottoMatchOutput(rank, checkLotto.get(rank));
        }

        LottoOutput.profitRate(lottoResultService.caculateProfitRate(lottos, winner));
    }

    private void lottoMatchOutput(final Rank rank, final Amount amount) {
        if (isBonusRank(rank)) {
            LottoOutput.matchBonusNumber(rank, amount);
            return;
        }
        LottoOutput.match(rank, amount);
    }

    private boolean isBonusRank(final Rank rank) {
        return rank == Rank.SECOND;
    }
}
