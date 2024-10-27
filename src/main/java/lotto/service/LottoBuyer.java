package lotto.service;

import lotto.model.BoughtLotto;
import lotto.model.WinningRecord;
import lotto.model.WinningLotto;

import java.util.*;

public class LottoBuyer {
    private static final int LOTTO_PRICE = 1000;

    private final List<BoughtLotto> boughtLottos;

    public LottoBuyer() {
        boughtLottos = new ArrayList<>();
    }

    public static void checkCanBuyLotto(int buyAmount, int manualLottoCount) {
        if (manualLottoCount * LOTTO_PRICE > buyAmount) {
            throw new IllegalArgumentException("구매할 수 있는 로또의 최대 개수를 초과하였습니다.");
        }
    }

    public static int calculateAutoLottoCount(int buyAmount, int manualLottoCount) {
        buyAmount -= manualLottoCount * LOTTO_PRICE;
        return buyAmount / LOTTO_PRICE;
    }

    public List<Integer> buyManualLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.boughtLottos.add(new BoughtLotto(lottoNumbers));

        return lottoNumbers;
    }

    public List<Integer> buyAutoLotto() {
        List<Integer> lottoNumbers = LottoSeller.sellLotto();

        Collections.sort(lottoNumbers);
        this.boughtLottos.add(new BoughtLotto(lottoNumbers));

        return lottoNumbers;
    }

    public Map<Integer, WinningRecord> checkLottoResult(String winningNumbers, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        return WinningAnalyzer.calculateWinningStatistics(winningLotto, boughtLottos);
    }

    public float checkReturnRate(int buyAmount, Map<Integer, WinningRecord> winningStatistics) {
        return WinningAnalyzer.calculateReturnRate(buyAmount, winningStatistics);
    }

    public List<BoughtLotto> getBoughtLottos() {
        return boughtLottos;
    }

}