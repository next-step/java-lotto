package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTest {

    @Test
    void getNumbers() {
        List<Integer> numbers = Arrays.asList(1, 4, 5, 6, 7, 8);
        assertThat(new Lotto(numbers).getNumbers().size()).isEqualTo(6);
    }
}