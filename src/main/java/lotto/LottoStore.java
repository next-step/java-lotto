package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final int BASE_AMOUNT = 1000;

    public List<Lotto> buy(int fee) {
        if (isInvalidBaseUnit(fee) || isNegative(fee)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }

        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < fee / BASE_AMOUNT; i++) {
            result.add(new Lotto(generateRandomNumbers()));
        }
        return result;
    }

    private boolean isNegative(int fee) {
        return fee < 0;
    }

    private List<Integer> generateRandomNumbers() {
        int min = LottoSettings.MIN.value();
        int max = LottoSettings.MAX.value();
        int size = LottoSettings.SIZE.value();
        return UniqueRandomNumberProvider.provideInRange(min, max, size);
    }

    private boolean isInvalidBaseUnit(int fee) {
        return fee % BASE_AMOUNT != 0;
    }
}
