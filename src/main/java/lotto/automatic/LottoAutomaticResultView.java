package lotto.automatic;

import java.util.ArrayList;
import java.util.List;

public class LottoAutomaticResultView {
    final static int PRICE = 1000;

    public int resultBuyPrice(int buyPrice) {


        int buyCount = buyPrice / PRICE;

        System.out.println(buyPrice);
        System.out.println(buyCount + "개를 구매했습니다.");

        return buyCount;

    }

    public void resultLottoList(ArrayList<List> lottoList) {


        for(List lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}
