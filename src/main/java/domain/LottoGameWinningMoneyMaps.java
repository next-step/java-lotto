package domain;

import java.util.HashMap;
import java.util.Map;

import static domain.LottoGameWinningMoneyType.*;

public class LottoGameWinningMoneyMaps {
    private final Map<Integer, Integer> map;

    public LottoGameWinningMoneyMaps() {
        this.map = new HashMap<>();
        initWinningMoneyMap();
    }

    private Map<Integer, Integer> initWinningMoneyMap() {
        map.put(0, NOTHING.getMoney());
        map.put(1, NOTHING.getMoney());
        map.put(2, NOTHING.getMoney());
        map.put(3, FORTH_WINNING_MONEY.getMoney());
        map.put(4, THIRD_WINNING_MONEY.getMoney());
        map.put(5, SECOND_WINNING_MONEY.getMoney());
        map.put(6, FIRST_WINNING_MONEY.getMoney());
        return map;
    }

    public int getBenefit(int hitNumber, int hitCount) {
        return map.get(hitNumber) * hitCount;
    }

    public int getWinningMoney(int index) {
        return map.get(index);
    }
}
