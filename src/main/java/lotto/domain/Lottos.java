package lotto.domain;

import lotto.strategy.RandomLottoNumber;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private List<Lotto> lottos;
    private Map<LottoResult, Integer> winningStatus;
    private int manualLottoQuantity;

    public Lottos(int purchaseQuantity, int manualLottoQuantity) {
        lottos = new ArrayList<>();
        winningStatus = new HashMap<>();
        this.manualLottoQuantity = manualLottoQuantity;

        setManualLotto(manualLottoQuantity);
        setAutomaticLotto(purchaseQuantity - manualLottoQuantity);
    }

    private void setManualLotto(int manualQuantity) {
        if (manualQuantity == 0) {
            return;
        }
        String[] manualNumbersArray = InputView.inputManualNumbers(manualQuantity);
        for (String numbers : manualNumbersArray) {
            lottos.add(Lotto.of(numbers));
        }
    }

    private void setAutomaticLotto(int automaticQuantity) {
        for (int i = 0; i < automaticQuantity; i++) {
            lottos.add(Lotto.of(RandomLottoNumber.generateRandomNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int getManualLottoQuantity() {
        return this.manualLottoQuantity;
    }

    public void checkLottosWinning(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean matchBonus = lotto.getMatchBonus(winningLotto);
            LottoResult lottoResult = LottoResult.getLottoResult(matchCount, matchBonus);
            setWinningStatus(lottoResult);
        }
    }

    private void setWinningStatus(LottoResult lottoResult) {
        if (lottoResult != LottoResult.FAIL) {
            winningStatus.put(lottoResult, winningStatus.getOrDefault(lottoResult, 0) + 1);
            LottoShop.getMoney()
                     .plusReward(lottoResult.getReward());
        }
    }

    public Map<LottoResult, Integer> getWinningStatus() {
        return winningStatus;
    }


}
