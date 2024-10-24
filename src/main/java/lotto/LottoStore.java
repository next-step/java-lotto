package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    public List<Lotto> buy(int fee) {
        if (isNotThousandUnit(fee)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요");
        }

        ArrayList<Lotto> result = new ArrayList<>();
        for (int i = 0; i < fee / 1000; i++) {
            List<Integer> numbers = IntStream.range(1, 7).boxed().collect(Collectors.toList());
            result.add(new Lotto(numbers));
        }
        return result;
    }

    private boolean isNotThousandUnit(int fee) {
        return fee % 1000 != 0;
    }
}
