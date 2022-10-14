package lotto;

import lotto.domain.*;
import lotto.ui.LottoInput;
import lotto.ui.LottoOutput;

import java.util.List;
import java.util.Map;

public class LottoController {

    private LottoService lottoService;

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
        Money money = LottoInput.money();
        return money;
    }

    private List<Lotto> purchaseLotto(Money money) {
        int count = lottoService.purchaseNumber(money);
        LottoOutput.purchaseCount(count);
        List<Lotto> lottos = lottoService.purchaseLotto(count);
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
        LottoOutput.match(3, LottoReward.FIFTH.reward(), checkLotto.get(LottoReward.FIFTH.rank()));
        LottoOutput.match(4, LottoReward.FOURTH.reward(), checkLotto.get(LottoReward.FOURTH.rank()));
        LottoOutput.match(5, LottoReward.THIRD.reward(), checkLotto.get(LottoReward.THIRD.rank()));
        LottoOutput.matchBonusNumber(5, LottoReward.SECOND.reward(), checkLotto.get(LottoReward.SECOND.rank()));
        LottoOutput.match(6, LottoReward.FIRST.reward(), checkLotto.get(LottoReward.FIRST.rank()));

        LottoOutput.yield(lottoService.yield(lottos, winner, money));
    }
}
