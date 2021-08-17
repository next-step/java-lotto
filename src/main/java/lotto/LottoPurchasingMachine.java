package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchasingMachine {
    public static final int AMOUNT = 1000;
    public static final int FIRST_PLACE_INDEX = 0;
    public static final int SECOND_PLACE_INDEX = 1;
    public static final int THIRD_PLACE_INDEX = 2;
    public static final int FOURTH_PLACE_INDEX = 3;
    public static final int FIRST_PRIZE_MONEY = 2000000000;
    public static final int SECOND_PRIZE_MONEY = 1500000;
    public static final int THIRD_PRIZE_MONEY = 50000;
    public static final int FOURTH_PRIZE_MONEY = 5000;

    public List<Lotto> buyLotto(int buyNumber) {
        int count = buyNumber / AMOUNT;
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public Integer[] checkLottoList(List<Lotto> lottoList, Integer[] prevLottoWinningNumbers) {
        Integer[] result = new Integer[] {0,0,0,0};
        for (Lotto lotto : lottoList) {
            int matchedNumberCount = lotto.getMatchedNumberCount(prevLottoWinningNumbers);
            getWinningResultCheck(matchedNumberCount, result);
        }
        return result;
    }

    private void getWinningResultCheck(int matchedNumberCount, Integer[] result) {
        switch (matchedNumberCount) {
            case 3:
                result[FOURTH_PLACE_INDEX]++;
                break;
            case 4:
                result[THIRD_PLACE_INDEX]++;
                break;
            case 5:
                result[SECOND_PLACE_INDEX]++;
                break;
            case 6:
                result[FIRST_PLACE_INDEX]++;
                break;
            default:
                break;
        }
    }

    public double getYield(Integer[] result, int purchaseAmount) {
        double prizeMoney = (double) getTotalPrizeMoney(result);
        return Math.floor((prizeMoney / purchaseAmount) * 100) / 100.0;
    }

    private long getTotalPrizeMoney(Integer[] result) {
        int prizeMoney = 0;
        prizeMoney += result[LottoPurchasingMachine.FIRST_PLACE_INDEX] * FIRST_PRIZE_MONEY;
        prizeMoney += result[LottoPurchasingMachine.SECOND_PLACE_INDEX] * SECOND_PRIZE_MONEY;
        prizeMoney += result[LottoPurchasingMachine.THIRD_PLACE_INDEX] * THIRD_PRIZE_MONEY;
        prizeMoney += result[LottoPurchasingMachine.FOURTH_PLACE_INDEX] * FOURTH_PRIZE_MONEY;
        return prizeMoney;
    }
}
