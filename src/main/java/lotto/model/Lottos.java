package lotto.model;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void countWinningResults(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int numberOfWinningNumbers = lotto.countWinningNumbers(winningNumbers);
            boolean bonus = lotto.contains(bonusNumber);
            addNumberOfWinning(numberOfWinningNumbers, bonus);
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

    public float getEarningRate(int earningPrice, int purchasePrice) {
        return (float) earningPrice / (float) purchasePrice;
    }

    public int getEarningPrice() {
        return (WinningPrice.FIFTH_PRICE.getPrice() * WinningResult.getNumberOfFifthPlace()
                + WinningPrice.FOURTH_PRICE.getPrice() * WinningResult.getNumberOfFourthPlace()
                + WinningPrice.THIRD_PRICE.getPrice() * WinningResult.getNumberOfThirdPlace()
                + WinningPrice.SECOND_PRICE.getPrice() * WinningResult.getNumberOfSecondPlace()
                + WinningPrice.FIRST_PRICE.getPrice() * WinningResult.getNumberOfFirstPlace());
    }
}
