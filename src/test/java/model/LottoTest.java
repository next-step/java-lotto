package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void getLottoSizeTest() {
        List<Integer> numbers = List.of(1, 2, 3, 5, 6, 7);
        Lotto lotto = new Lotto(numbers);
        int expected = 6;
        assertThat(lotto.size()).isEqualTo(expected);
    }
}
