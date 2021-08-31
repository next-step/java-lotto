package lotto;

import util.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoPurchasingMachine {
    public static final int AMOUNT = 1_000;
    public static final int ADD_LOTTO_COUNT = 1;

    public List<Lotto> buyAutomaticLotto(int buyNumber) {
        int count = buyNumber / AMOUNT;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

    public List<Lotto> buyManualLotto(String[] manualNumbers) {
        List<Lotto> lottoList = new ArrayList<>();
        for (String manualNumber : manualNumbers) {
            lottoList.add(new Lotto(Number.stringArrayToIntegerList(Arrays.asList(manualNumber.split(",")))));
        }
        return lottoList;
    }

    public List<Integer> checkLottoList(List<Lotto> lottoList, List<Integer> prevLottoWinningNumbers, int bonusNumber) {
        List<Integer> result = Arrays.asList(new Integer[] {0,0,0,0,0,0});
        WinningLotto winningLotto = new WinningLotto(new Lotto(prevLottoWinningNumbers), bonusNumber);

        for (Lotto lotto : lottoList) {
            Rank rank = winningLotto.matchedRank(lotto);
            result.set(rank.getPlaceIndex(), result.get(rank.getPlaceIndex()) + ADD_LOTTO_COUNT);
        }
        return result;
    }

    public double findYield(List<Integer> result, int purchaseAmount) {
        double prizeMoney = (double) findTotalPrizeMoney(result);
        return Math.floor((prizeMoney / purchaseAmount) * 100) / 100.0;
    }

    private long findTotalPrizeMoney(List<Integer> result) {
        int prizeMoney = 0;
        for (Rank constant : Rank.values()) {
            prizeMoney += result.get(constant.getPlaceIndex()) * constant.getPrizeMoney();
        }
        return prizeMoney;
    }
}
