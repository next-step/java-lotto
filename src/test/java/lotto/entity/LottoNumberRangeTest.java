package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberRangeTest {

    @Test
    void 번호_리스트_초기화() {
        List<Integer> numbers = LottoNumberRange.initNumber();

        assertThat(numbers).hasSize(45);
    }

    @Test
    void 범위_초과_예외() {
        assertThatThrownBy(
                () -> LottoNumberRange.validateRange(55)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
