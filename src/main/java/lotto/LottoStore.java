package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    private static final int BASE_AMOUNT = 1000;

    public List<Lotto> buy(int fee) {
        if (isInvalidBaseUnit(fee)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요");
        }

        ArrayList<Lotto> result = new ArrayList<>();
        for (int i = 0; i < fee / BASE_AMOUNT; i++) {
            List<Integer> numbers = UniqueRandomNumberProvider.provideInRange(1, 45, 6);
            result.add(new Lotto(numbers));
        }
        return result;
    }

    private boolean isInvalidBaseUnit(int fee) {
        return fee % BASE_AMOUNT != 0;
    }
}
