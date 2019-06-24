package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoRetailer {

    private final static Integer UNIT_PRICE = 1000;

    public static List<LottoNumbers> buy(int orderAmount ) {
        verifyBuyMinimum(orderAmount);
        int quantity = getAvailableNumberToBuy(orderAmount);

        List<LottoNumbers> list = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
            list.add(lottoNumbers);
        }
        return list;
    }

    private static void verifyBuyMinimum(int orderAmount) {
        if(orderAmount < UNIT_PRICE) {
            throw new IllegalArgumentException("이걸론 한장도 못사");
        }
    }

    private static int getAvailableNumberToBuy(int orderAmount) {
        return orderAmount / UNIT_PRICE;
    }


}
