package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoCountTest {

    @Test
    @DisplayName("수동으로 구매할 로또 개수가 null이면 예외(null => IllegalArgumentException)")
    void is_null() {
        assertThatThrownBy(() -> {
            new ManualLottoCount(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동으로 구매할 로또 개수가 구매할 수 있는 로또 개수보다 크면 예외(14000, 15 => IllegalArgumentException)")
    void is_larger_than_whole_count() {
        assertThatThrownBy(() -> {
            new ManualLottoCount(15).validateIfLargerThanWholeCount(new Cash(1400));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
