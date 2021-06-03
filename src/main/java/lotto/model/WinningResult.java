package lotto.model;

import java.util.List;

public class WinningResult {
    static

    public WinningResult(List<Lotto> lottos, WinningLotto winningLotto) {
        getWinningResult(lottos, winningLotto.getWinningNumbers(), winningLotto.getBonusNumber());
        map.put("numberOfFirstPlace", 0);
        map.put("numberOfSecondPlace", 0);
        map.put("numberOfThirdPlace", 0);
        map.put("numberOfFourthPlace", 0);
        map.put("numberOfFifthPlace", 0);
    }

    public static int getNumberOfFirstPlace() {
        return map.get("numberOfFirstPlace");
    }

    public static int getNumberOfSecondPlace() {
        return map.get("numberOfSecondPlace");
    }

    public static int getNumberOfThirdPlace() {
        return map.get("numberOfThirdPlace");
    }

    public static int getNumberOfFourthPlace() {
        return map.get("numberOfFourthPlace");
    }

    public static int getNumberOfFifthPlace() {
        return map.get("numberOfFifthPlace");
    }

    public void getWinningResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            String result = lotto.result(winningNumbers, bonusNumber);
            WinningResult.addNumberOfWinning(result);
        }
    }

    public static void addNumberOfWinning(int numberOfWinningNumbers, boolean bonus) {
        if (numberOfWinningNumbers == 3) {
            int number = map.get("numberOfFifthPlace");
            map.put("numberOfFifthPlace", ++number);
        }

        if (numberOfWinningNumbers == 4) {
            int number = map.get("numberOfFourthPlace");
            map.put("numberOfFourthPlace", ++number);
        }

        if (numberOfWinningNumbers == 5 && !bonus) {
            int number = map.get("numberOfThirdPlace");
            map.put("numberOfThirdPlace", ++number);
        }

        if (numberOfWinningNumbers == 5 && bonus) {
            int number = map.get("numberOfSecondPlace");
            map.put("numberOfSecondPlace", ++number);
        }

        if (numberOfWinningNumbers == 6) {
            int number = map.get("numberOfFirstPlace");
            map.put("numberOfFirstPlace", ++number);
        }
    }
}
