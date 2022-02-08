package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRules {
    
    public static final int START_NUM = 1;
    public static final int LAST_NUM = 45;
    public static final int LOTTO_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;
    private static final int HUNDRED = 100;
    private static List<Integer> LOTTO_NUMS;
    
    LottoRules() {
        List<Integer> lottoNums = new ArrayList<>();
        for (int i = START_NUM; i <= LAST_NUM; i++) {
            lottoNums.add(i);
        }
        this.LOTTO_NUMS = lottoNums;
    }
    
    public static double calculateYield(double reward, int lottoCount) {
        double price = lottoCount * LOTTO_PRICE;
        double yield = reward / price;
        return (double) ((int) (HUNDRED * yield)) / HUNDRED;
    }
    
    public List<Integer> getLottoNums() {
        return LOTTO_NUMS;
    }
}
