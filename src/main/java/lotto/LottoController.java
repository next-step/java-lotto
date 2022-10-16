package lotto;

import lotto.domain.*;
import lotto.ui.LottoInput;
import lotto.ui.LottoOutput;

import java.util.List;
import java.util.Map;

public class LottoController {

    private LottoService lottoService;
    public static int REWARD_START_RANK = 5;
    public static int REWARD_END_RANK = 1;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void draw() {
        Money money = purchaseMoney();

        List<Lotto> lottos = purchaseLotto(money);

        LottoWinner winner = drawWinner();

        lottoResult(money, lottos, winner);
    }

    private Money purchaseMoney() {
        LottoOutput.purchaseAmount();

        return LottoInput.money();
    }

    private List<Lotto> purchaseLotto(Money money) {
        Amount amount = lottoService.purchaseNumber(money);

        LottoOutput.purchaseCount(amount);

        List<Lotto> lottos = lottoService.purchaseLotto(amount);
        LottoOutput.lotto(lottos);
        return lottos;
    }

    private LottoWinner drawWinner() {
        LottoOutput.winningNumber();
        LottoNumberSet numbers = LottoInput.winnerNumbers();

        LottoOutput.bonusNumber();
        LottoNumber bonusNumber = LottoInput.bonusNumber();

        return new LottoWinner(numbers, bonusNumber);
    }

    private void lottoResult(Money money, List<Lotto> lottos, LottoWinner winner) {
        Map<Integer, Integer> checkLotto = lottoService.checkLotto(lottos, winner);

        LottoOutput.statistics();
        for (int rank = REWARD_START_RANK; rank >= REWARD_END_RANK; rank--) {
            lottoMatchOutput(rank, checkLotto.get(rank));
        }

        LottoOutput.yield(lottoService.yield(lottos, winner, money));
    }

    private void lottoMatchOutput(int rank, int matchNumber) {
        if (bonusRank(rank)) {
            LottoOutput.matchBonusNumber(LottoReward.count(rank), LottoReward.reward(rank), matchNumber);
        }
        LottoOutput.match(LottoReward.count(rank), LottoReward.reward(rank), matchNumber);
    }

    private boolean bonusRank(int rank) {
        return rank == 2;
    }
}
