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
        LottoNumbers lottoNumbers = new LottoNumbers();
        for (int i = 0; i < purchasedCount; i++) {
            lottoNumbers.addLotto(createRandomLotto());
        }
        return lottoNumbers;
    }

    private Lotto createRandomLotto() {
        List<Integer> lottoNumRange = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            lottoNumRange.add(i);
        }
        Collections.shuffle(lottoNumRange);
        List<Integer> pickedNumbers = lottoNumRange.subList(0, 6);
        Collections.sort(pickedNumbers);
        return Lotto.from(pickedNumbers);

    }


}
