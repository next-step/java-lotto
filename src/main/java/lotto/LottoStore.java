package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class LottoStore {
    private LottoStore() {

    }

    public static Lotto purchase(int manualCount, int autoCount, Supplier<LottoNumbers> manualSupplier) {
        return purchase(manualCount, autoCount, manualSupplier, LottoStore::randomLottoNumbers);
    }

    public static Lotto purchase(int manualCount, int autoCount,
                                 Supplier<LottoNumbers> manualSupplier, Supplier<LottoNumbers> autoSupplier) {
        List<LottoNumbers> numbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            numbers.add(manualSupplier.get());
        }

        for (int i = 0; i < autoCount; i++) {
            numbers.add(autoSupplier.get());
        }
        return new Lotto(numbers);
    }

    private static LottoNumbers randomLottoNumbers() {
        List<LottoNumber> candidates = new ArrayList<>(LottoNumber.selectableNumbers());
        Collections.shuffle(candidates);
        return LottoNumbers.ofNumbers(candidates.subList(0, LottoNumbers.LOTTO_NUMBER_COUNT));
    }
}
