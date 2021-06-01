package lotto;


import lotto.domain.entity.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    void create() {
        Number number = Number.of(1);
        assertThat(number).isEqualTo(Number.of(1));
        assertThat(number).isEqualTo(Number.of("1"));
        assertThat(number == Number.of("1") && number == Number.of(1)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("숫자는 1부터 45까지의 범위를 가진다.")
    @ValueSource(ints = {0, 46})
    public void 로또_숫자_범위(int number) {
        assertThatThrownBy(() -> Number.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자 범위는 1 ~ 45 사이입니다.");
    }
}