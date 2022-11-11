package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {
    public static final int LOTTO_PRICE = 1000;

    private LottoStore() {

    }

    public static List<LottoNumbers> purchaseAuto(int purchasePrice, int manualCount) {
        int autoCount = (purchasePrice - manualCount * LOTTO_PRICE) / LOTTO_PRICE;
        if (autoCount < 0 || (autoCount == 0 && manualCount == 0)) {
            throw new IllegalArgumentException("구입 금액이 너무 작습니다.");
        }
        return purchaseAuto(autoCount);
    }

    private static List<LottoNumbers> purchaseAuto(int count) {
        List<LottoNumbers> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(randomLottoNumbers());
        }
        return result;
    }

    private static LottoNumbers randomLottoNumbers() {
        List<LottoNumber> candidates = new ArrayList<>(LottoNumber.selectableNumbers());
        Collections.shuffle(candidates);
        return LottoNumbers.ofNumbers(candidates.subList(0, LottoNumbers.LOTTO_NUMBER_COUNT));
    }
}
