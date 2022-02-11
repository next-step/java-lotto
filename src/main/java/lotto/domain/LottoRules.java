package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRules {
    
    public static final int START_NUM = 1;
    public static final int LAST_NUM = 45;
    public static final int LOTTO_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;
    private static final int HUNDRED = 100;
    private static final List<Integer> LOTTO_NUMS = IntStream.rangeClosed(START_NUM, LAST_NUM)
      .boxed().collect(
        Collectors.toList());
    
    
    public static double calculateYield(double reward, int lottoCount) {
        double price = lottoCount * LOTTO_PRICE;
        double yield = reward / price;
        return (double) ((int) (HUNDRED * yield)) / HUNDRED;
    }
    
    public static List<Integer> getLottoNums() {
        return LOTTO_NUMS;
    }
}
