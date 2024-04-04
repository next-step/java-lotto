package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private static final int LOTTO_SINGULAR_PRICE = 1000;

    public static List<Lotto> purchaseLotto(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < purchaseAmount / LOTTO_SINGULAR_PRICE; i++) {
            lottoList.add(new Lotto(generateLottoNumbers()));
        }

        return lottoList;
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("구매 금액은 음수가 될 수 없습니다.");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로 구입할 수 있습니다.");
        }
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numList = new ArrayList<>();

        for (int i = Lotto.LOWER_BOUND; i <= Lotto.UPPER_BOUND; i++) numList.add(i);
        Collections.shuffle(numList);

        return numList.subList(0, 6);
    }
}
