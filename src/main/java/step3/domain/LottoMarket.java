package step3.domain;

import step3.strategy.LottoMatcher;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoMarket {

    private static final int PRICE = 1000;

    private LottoMachine machine;
    private Lotteries myLottoList;
    private LottoMatcher matcher = new LottoMatcher();

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

    public Map<Winning, Integer> checkNumToWinner(Lotto winner, int bonus) {
        List<Winning> result = new ArrayList<>();
        WinnerLotto winnerLotto = WinnerLotto.of(winner,bonus);
        for (Lotto myLotto : myLottoList.getAll()) {
            Winning winning = matcher.getWinning(myLotto, winnerLotto);
            if (!winning.isNotThing()) {
                result.add(winning);
            }

        }
        return listToMap(result);
    }


    private Map<Winning, Integer> listToMap(List<Winning> result) {
        Map<Winning, Integer> resultMap = new LinkedHashMap<>();

        for (Winning winning : Winning.values()) {
            resultMap.put(winning, 0);
        }
        resultMap.remove(Winning.NOTHING);
        for (Winning Winning : result) {
            resultMap.put(Winning, resultMap.get(Winning) + 1);
        }
        return resultMap;
    }

}
