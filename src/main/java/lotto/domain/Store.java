package lotto.domain;

import java.util.List;

public class Store {
    private final int PRICE = 1000;
    private List<Lotto> lottoBundle;

    public int purchase(String budget) {
        int numberOfPurchase =  Integer.parseInt(budget) / PRICE;

        for(int i = 0; i<numberOfPurchase; i++) {
            lottoBundle.add(new Lotto());
        }

        return numberOfPurchase;
    }
}
