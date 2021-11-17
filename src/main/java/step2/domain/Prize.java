package step2.domain;

import step2.view.Input;

import java.util.Arrays;
import java.util.List;

public class Prize {
    public static List<Integer> prizeList = Arrays.asList(0,0,0,5000, 50000, 1500000, 2000000000);

    public static double calculatorYield(List<Integer> countList,Integer purchaseAmount) {
        double resultPrize = 0L;
        for (int i = 0; i < countList.size(); i++) {
            resultPrize += countList.get(i) * prizeList.get(i);
        }
        return (resultPrize / new Double(purchaseAmount));
    }
}
