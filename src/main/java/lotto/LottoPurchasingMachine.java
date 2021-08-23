package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoPurchasingMachine {
    public static final int AMOUNT = 1_000;

    public List<Lotto> buyLotto(int buyNumber) {
        int count = buyNumber / AMOUNT;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public List<Integer> checkLottoList(List<Lotto> lottoList, List<Integer> prevLottoWinningNumbers, int bonusNumber) {
        Integer[] result = new Integer[] {0,0,0,0,0,0};
        for (Lotto lotto : lottoList) {
            int matchedNumberCount = lotto.findMatchedNumberCount(prevLottoWinningNumbers);
            checkWinningResult(matchedNumberCount, Arrays.asList(result), lotto.checkBonusBallNumber(bonusNumber));
        }
        return Arrays.asList(result);
    }

    private void checkWinningResult(int matchedNumberCount, List<Integer> result, boolean checkBonusNumber) {
        Rank rank = Rank.valueOf(matchedNumberCount, checkBonusNumber);
        result.set(rank.getPlaceIndex(), result.get(rank.getPlaceIndex()) + 1);
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
