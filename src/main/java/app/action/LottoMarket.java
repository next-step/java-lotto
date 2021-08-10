package app.action;

import app.domain.Money;
import app.domain.Winning;
import app.domain.lotto.Lotteries;
import app.domain.lotto.Lotto;
import app.domain.lotto.WinnerLotto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoMarket {

    public static final int PRICE = 1000;

    private LottoMachine machine;
    private Lotteries myLottoList;

    public LottoMarket(LottoMachine machine, Lotteries list) {
        this.machine = machine;
        this.myLottoList = list;
    }

    public int buy(Money money) {
        int count = money.countLotto(PRICE);
        for (int i = 0; i < count; i++) {
            myLottoList.buyLotto(machine);
        }
        return PRICE * count;
    }

    public Map<Winning, Integer> checkNumToWinner(WinnerLotto winner) {
        List<Winning> result = new ArrayList<>();

        for (Lotto myLotto : myLottoList.getAll()) {
            Winning winning = myLotto.getWinning(winner.getLotto().getNumbers(), winner.getBonus());
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
