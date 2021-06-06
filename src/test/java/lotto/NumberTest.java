package lotto;


import lotto.domain.entity.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @Test
    @DisplayName("Number 생성 테스트")
    public void create() {
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

    @ParameterizedTest
    @DisplayName("텍스트가 숫자가 아닐때 오류")
    @ValueSource(strings = {"A", "!", "ㄱ", ",", "A!ㄱ,"})
    public void 텍스트_오류_확인(String text) {
        assertThatThrownBy(() -> Number.of(text))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }
}