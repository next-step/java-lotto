package lotto.support;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFixture {

    public static Lotto of(int... numbers) {

        List<Integer> list = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());

        return new Lotto(list);
    }
}
