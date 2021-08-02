package step2.domain;

import java.util.*;

public class LottoMarket {

    private static final int PRICE = 1000;

    private LottoMachine machine;
    private Lotteries myLottoList;

    public LottoMarket(LottoMachine machine, Lotteries list) {
        this.machine = machine;
        this.myLottoList = list;
    }

    public int buy(int money) {
        int count = money / PRICE;
        for (int i = 0; i < count; i++) {
            myLottoList.buyLotto(machine);
        }
        return PRICE * count;
    }

    public Map<Winnings, Integer> checkNumToWinner(Lotto winner) {
        List<Winnings> result = new ArrayList<>();

        for (Lotto myLotto : myLottoList.getAll()) {
            int matchCount = matchLotto(winner, myLotto);
            putResult(result, matchCount);
        }
        return listToMap(result);
    }

    private int matchLotto(Lotto winner, Lotto myLotto) {
        int count = 0;
        for (int number : myLotto.getNumbers()) {
            count = checkLotto(winner, number, count);
        }
        return count;
    }

    private int checkLotto(Lotto winner, int number, int count) {
        if (winner.getNumbers().contains(number)) {
            count++;
        }
        return count;
    }

    private void putResult(List<Winnings> result, int matchCount) {
        if (matchCount >= 3) {
            result.add(Winnings.find(matchCount));
        }
    }

    private Map<Winnings, Integer> listToMap(List<Winnings> result) {
        Map<Winnings, Integer> resultMap = new LinkedHashMap<>();

        for (Winnings winnings : Winnings.values()) {
            resultMap.put(winnings, 0);
        }
        resultMap.remove(Winnings.NOTHING);
        for (Winnings WINNINGS : result) {
            resultMap.put(WINNINGS, resultMap.get(WINNINGS) + 1);
        }
        return resultMap;
    }

}
