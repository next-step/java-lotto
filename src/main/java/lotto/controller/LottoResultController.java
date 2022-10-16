package lotto.controller;

import lotto.domain.Money.ImmutableMoney;
import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;
import lotto.service.LottoService;
import lotto.domain.*;
import lotto.domain.lotto.*;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.List;
import java.util.Map;

public class LottoResultController {

    private final LottoService lottoService;
    private static final int REWARD_START_RANK = 5;
    private static final int REWARD_END_RANK = 1;
    private static final int BONUS_RANK = 2;


    public LottoResultController(final LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void draw(final List<Lotto> lottos, final ImmutableMoney money) {
        lottoResult(money, lottos, drawWinner());
    }

    private LottoWinner drawWinner() {
        LottoOutput.winningNumber();
        LottoNumberSet numbers = LottoInput.lottoNumbers();

        LottoOutput.bonusNumber();
        LottoNumber bonusNumber = LottoInput.bonusNumber();

        return new LottoWinner(numbers, bonusNumber);
    }

    private void lottoResult(final ImmutableMoney money, final List<Lotto> lottos, final LottoWinner winner) {
        Map<Integer, Integer> checkLotto = lottoService.checkLotto(lottos, winner);

        LottoOutput.statistics();
        for (int rank = REWARD_START_RANK; rank >= REWARD_END_RANK; rank--) {
            lottoMatchOutput(rank, checkLotto.get(rank));
        }

        LottoOutput.yield(lottoService.yield(lottos, winner, money));
    }

    private void lottoMatchOutput(final int rank, final int matchNumber) {
        if (isBonusRank(rank)) {
            LottoOutput.matchBonusNumber(LottoReward.count(rank), LottoReward.reward(rank), matchNumber);
            return;
        }
        LottoOutput.match(LottoReward.count(rank), LottoReward.reward(rank), matchNumber);
    }

    private boolean isBonusRank(final int rank) {
        return rank == BONUS_RANK;
    }
}
