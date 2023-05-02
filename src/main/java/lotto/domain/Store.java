package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Store {
    private static final Pattern BUDGET_PATTERN = Pattern.compile("^[1-9]{1}[0-9]+$");

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
