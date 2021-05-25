package lotto.model;

import java.util.List;

public class WinningResult {

    private static int numberOfFirstPlace = 0;
    private static int numberOfSecondPlace = 0;
    private static int numberOfThirdPlace = 0;
    private static int numberOfFourthPlace = 0;
    private static int numberOfFifthPlace = 0;

    public WinningResult() {
    }

    public static int getNumberOfFirstPlace() {
        return numberOfFirstPlace;
    }

    public static int getNumberOfSecondPlace() {
        return numberOfSecondPlace;
    }

    public static int getNumberOfThirdPlace() {
        return numberOfThirdPlace;
    }

    public static int getNumberOfFourthPlace() {
        return numberOfFourthPlace;
    }

    public static int getNumberOfFifthPlace() {
        return numberOfFifthPlace;
    }

    public static void addCount(int count, boolean bonus) {
        if (count == 3) {
            numberOfFifthPlace++;
        }
        if (count == 4) {
            numberOfFourthPlace++;
        }
        if (count == 5 && !bonus) {
            numberOfThirdPlace++;
        }
        if (count == 5 && bonus) {
            numberOfSecondPlace++;
        }
        if (count == 6) {
            numberOfFirstPlace++;
        }
    }

    public void getWinningResult(List<LottoModel> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (LottoModel lotto : lottos) {
            int count = lotto.countWinningNumbers(winningNumbers);
            boolean bonus = lotto.contains(bonusNumber);
            WinningResult.addCount(count, bonus);
        }
    }
}
