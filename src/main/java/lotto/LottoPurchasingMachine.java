package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoPurchasingMachine {
    public static final int AMOUNT = 1_000;
    public static final int FIRST_PLACE_INDEX = 0;
    public static final int SECOND_PLACE_INDEX = 1;
    public static final int THIRD_PLACE_INDEX = 2;
    public static final int FOURTH_PLACE_INDEX = 3;
    public static final int FIRST_PRIZE_MONEY = 2_000_000_000;
    public static final int SECOND_PRIZE_MONEY = 1_500_000;
    public static final int THIRD_PRIZE_MONEY = 50_000;
    public static final int FOURTH_PRIZE_MONEY = 5_000;

    public List<Lotto> buyLotto(int buyNumber) {
        int count = buyNumber / AMOUNT;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public List<Integer> checkLottoList(List<Lotto> lottoList, List<Integer> prevLottoWinningNumbers) {
        Integer[] result = new Integer[] {0,0,0,0};
        for (Lotto lotto : lottoList) {
            int matchedNumberCount = lotto.findMatchedNumberCount(prevLottoWinningNumbers);
            checkWinningResult(matchedNumberCount, Arrays.asList(result));
        }
        return Arrays.asList(result);
    }

    private void checkWinningResult(int matchedNumberCount, List<Integer> result) {
        switch (matchedNumberCount) {
            case 3:
                result.set(FOURTH_PLACE_INDEX, result.get(FOURTH_PLACE_INDEX) + 1);
                break;
            case 4:
                result.set(THIRD_PLACE_INDEX, result.get(THIRD_PLACE_INDEX) + 1);
                break;
            case 5:
                result.set(SECOND_PLACE_INDEX, result.get(SECOND_PLACE_INDEX) + 1);
                break;
            case 6:
                result.set(FIRST_PLACE_INDEX, result.get(FIRST_PLACE_INDEX) + 1);
                break;
            default:
                break;
        }
    }

    public double findYield(List<Integer> result, int purchaseAmount) {
        double prizeMoney = (double) findTotalPrizeMoney(result);
        return Math.floor((prizeMoney / purchaseAmount) * 100) / 100.0;
    }

    private long findTotalPrizeMoney(List<Integer> result) {
        int prizeMoney = 0;
        prizeMoney += result.get(LottoPurchasingMachine.FIRST_PLACE_INDEX) * FIRST_PRIZE_MONEY;
        prizeMoney += result.get(LottoPurchasingMachine.SECOND_PLACE_INDEX) * SECOND_PRIZE_MONEY;
        prizeMoney += result.get(LottoPurchasingMachine.THIRD_PLACE_INDEX) * THIRD_PRIZE_MONEY;
        prizeMoney += result.get(LottoPurchasingMachine.FOURTH_PLACE_INDEX) * FOURTH_PRIZE_MONEY;
        return prizeMoney;
    }
}
