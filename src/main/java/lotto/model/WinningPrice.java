package lotto.model;

import java.util.HashMap;
import java.util.List;

public enum WinningPrice {
    FIFTH_PRICE(5_000),
    FOURTH_PRICE(50_000),
    THIRD_PRICE(1_500_000),
    SECOND_PRICE(30_000_000),
    FIRST_PRICE(2_000_000_000);

    private int price;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    WinningPrice(int price) {
        this.price = price;

        map.put(FIFTH_PRICE.getPrice(), )
    }



    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
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

    public void getWinningResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int numberOfWinningNumbers = lotto.countWinningNumbers(winningNumbers);
            boolean bonus = lotto.contains(bonusNumber);
            WinningResult.addNumberOfWinning(numberOfWinningNumbers, bonus);
        }
    }
}
