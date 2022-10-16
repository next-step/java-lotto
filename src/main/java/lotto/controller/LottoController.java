package lotto.controller;

import lotto.domain.Money.Money;
import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;
import lotto.service.LottoService;
import lotto.domain.*;
import lotto.domain.lotto.*;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

import java.util.ArrayList;
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
        Amount totalAmount = lottoService.purchaseNumber(money);
        List<Lotto> lottoList = purchaseAutoLotto(totalAmount, purchaseManualLotto());
        LottoOutput.lotto(lottoList);
        return lottoList;
    }

    private List<Lotto> purchaseAutoLotto(Amount totalAmount, List<Lotto> lottoList) {
        Amount autoAmount = totalAmount.minus(new Amount(lottoList.size()));
        LottoOutput.purchaseCount(new Amount(lottoList.size()), autoAmount);
        lottoList.addAll(lottoService.purchaseLotto(autoAmount));
        return lottoList;
    }

    private List<Lotto> purchaseManualLotto() {
        LottoOutput.purchaseManualAmount();
        Amount manualAmount = LottoInput.purchaseManualAmount();
        LottoOutput.manualLottoNumbers();
        return lottoService.purchaseLotto(inputLottoNumberSet(manualAmount));
    }

    private static List<LottoNumberSet> inputLottoNumberSet(Amount manualAmount) {
        List<LottoNumberSet> lottoNumberSets = new ArrayList<>();
        for (int i = 0; i < manualAmount.amount(); i++) {
            lottoNumberSets.add(LottoInput.lottoNumbers());
        }
        return lottoNumberSets;
    }

    private LottoWinner drawWinner() {
        LottoOutput.winningNumber();
        LottoNumberSet numbers = LottoInput.lottoNumbers();

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
            return;
        }
        LottoOutput.match(LottoReward.count(rank), LottoReward.reward(rank), matchNumber);
    }

    private boolean bonusRank(int rank) {
        return rank == 2;
    }
}
