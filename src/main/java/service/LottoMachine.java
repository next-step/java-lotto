package service;

import domain.Lotto;
import domain.LottoNumbers;
import domain.Money;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;


    public LottoNumbers purchaseLotto(Money money) {

        int purchasedCount = money.getMoney() / LOTTO_PRICE;

        for (int i = 0; i < purchasedCount; i++) {

        }
    }

    private Lotto createRandomLotto() {
        List<Integer> lottoNumRange = new ArrayList<>();

        for (int i = 0; i <= 45; i++) {
            lottoNumRange.add(i);
        }
        Collections.shuffle(lottoNumRange);
        List<Integer> pickedNumbers = lottoNumRange.subList(0, 5);
        Collections.sort(pickedNumbers);

    }


}
