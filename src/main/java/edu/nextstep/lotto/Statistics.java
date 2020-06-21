package edu.nextstep.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private static final int THREE_EQUAL_NUM = 3;
    private static final int FOUR_EQUAL_NUM = 4;
    private static final int FIVE_EQUAL_NUM = 5;
    private static final int SIX_EQUAL_NUM = 6;

    private Map<Integer, Integer> result;
    public static Map<Integer, Integer> info;

    Statistics() {
        this.result = new HashMap<Integer, Integer>();
        this.result.put(THREE_EQUAL_NUM, 0);
        this.result.put(FOUR_EQUAL_NUM, 0);
        this.result.put(FIVE_EQUAL_NUM, 0);
        this.result.put(SIX_EQUAL_NUM, 0);

        this.info = new HashMap<Integer, Integer>();
        this.info.put(THREE_EQUAL_NUM, 5000);
        this.info.put(FOUR_EQUAL_NUM, 50000);
        this.info.put(FIVE_EQUAL_NUM, 1500000);
        this.info.put(SIX_EQUAL_NUM, 2000000000);
    }

    public Map<Integer, Integer> getResult(List lottoList, String[] winNumber) {
        for (int i = 0; i < lottoList.size(); i++) {
            checkEqualNum(lottoList, winNumber, i, THREE_EQUAL_NUM);
            checkEqualNum(lottoList, winNumber, i, FOUR_EQUAL_NUM);
            checkEqualNum(lottoList, winNumber, i, FIVE_EQUAL_NUM);
            checkEqualNum(lottoList, winNumber, i, SIX_EQUAL_NUM);
        }
        return result;
    }

    public float checkProfit(int money, Map<Integer, Integer> result) {
        if (result == null) {
            throw new NullPointerException("result is null");
        }

        int reward = 0;
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            reward = reward + info.get(entry.getKey()) * entry.getValue();
        }
        return reward / money;
    }

    private void checkEqualNum(List lottoList, String[] winNumber, int i, int equalNum) {
        if (((Lotto) lottoList.get(i)).checkLotto(winNumber) == equalNum) {
            int count = this.result.get(equalNum);
            this.result.put(equalNum, count++);
        }
    }
}
