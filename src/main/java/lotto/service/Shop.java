package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.SingleOrder;
import lotto.parser.LottoNumberParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private static final String LOTTO_PRODUCT_NAME = "Lotto";

    private Shop() {
        throw new IllegalStateException(ErrorMessage.CANNOT_BE_INSTANTIATED.getMessage());
    }

    public static SingleOrder createLottoPurchase(int purchaseAmount) {
        return new SingleOrder(LOTTO_PRODUCT_NAME, purchaseAmount);
    }

    public static List<Lotto> getLottoList(SingleOrder purchase, List<String> manualInputLottoNumbers) {
        List<Lotto> lottoList = new ArrayList<>();

        if (!manualInputLottoNumbers.isEmpty()) {
            lottoList.addAll(Shop.getManualInputLotto(manualInputLottoNumbers));
        }

        lottoList.addAll(Shop.getAutomaticLotto(purchase.getPurchaseAmount() - manualInputLottoNumbers.size()));

        return lottoList;
    }

    public static void validateManualPurchaseCount(SingleOrder purchase, int manualPurchaseCount) {
        if (manualPurchaseCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_MANUAL_PURCHASE_COUNT.getMessage());
        }

        if (purchase.isOverPurchaseAmount(manualPurchaseCount)) {
            throw new IllegalArgumentException(ErrorMessage.OVER_WHOLE_PURCHASE_COUNT.getMessage());
        }
    }

    private static List<Lotto> getManualInputLotto(List<String> manualInputLottoNumbers) {
        List<Lotto> lottoList = new ArrayList<>();

        manualInputLottoNumbers.forEach(lottoNumber -> lottoList.add(new Lotto(LottoNumberParser.parse(lottoNumber))));

        return lottoList;
    }

    private static List<Lotto> getAutomaticLotto(int count) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
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
