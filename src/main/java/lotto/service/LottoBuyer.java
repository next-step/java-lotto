package lotto.service;

import lotto.model.BoughtLotto;
import lotto.model.WinningInfo;
import lotto.model.WinningLotto;

import java.util.*;

public class LottoBuyer {
    private static final int LOTTO_PRICE = 1000;

    private final List<BoughtLotto> boughtLottos;
    private WinningAnalyzer winningAnalyzer;

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

    public Map<Integer, WinningInfo> checkLottoResult(String winningNumbers, int bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        winningAnalyzer = new WinningAnalyzer();

        return winningAnalyzer.calculateWinningStatics(winningLotto, boughtLottos);
    }

    public float checkReturnRate(int buyAmount) {
        return winningAnalyzer.calculateReturnRate(buyAmount);
    }

    public List<BoughtLotto> getBoughtLottos() {
        return boughtLottos;
    }

}