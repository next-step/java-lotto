package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Purchase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private static final String LOTTO_PRODUCT_NAME = "Lotto";

    public static List<Lotto> purchaseLotto(int purchaseAmount) {
        Purchase purchase = new Purchase(LOTTO_PRODUCT_NAME, purchaseAmount);

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < purchase.getPurchaseAmount(); i++) {
            lottoList.add(new Lotto(generateLottoNumbers()));
        }

        return lottoList;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numList = new ArrayList<>();

        for (int i = Lotto.LOWER_BOUND; i <= Lotto.UPPER_BOUND; i++) numList.add(i);
        Collections.shuffle(numList);

        return numList.subList(0, 6);
    }
}
