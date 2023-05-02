package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final int PRICE = 1000;

    public List<Lotto> purchase(String budget) {
        int numberOfPurchase =  Integer.parseInt(budget) / PRICE;
        List<Lotto> lottoBundle = new ArrayList<>();

        for(int i = 0; i<numberOfPurchase; i++) {
            lottoBundle.add(new Lotto());
        }

        return lottoBundle;
    }


}
