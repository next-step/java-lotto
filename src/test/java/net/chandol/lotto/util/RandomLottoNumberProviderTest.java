package net.chandol.lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class RandomLottoNumberProviderTest {

    @Test
    public void 랜덤결과확인() {
        List<Integer> numbers = RandomLottoNumberProvider.getNumbers();
        Assertions.assertThat(numbers)
                .hasSize(6)
                .allMatch(i -> i <= 45 || i >= 1);
    }
}