package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {
    private LottoStore() {

    }

    public static List<LottoNumbers> purchaseAuto(int count) {
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
