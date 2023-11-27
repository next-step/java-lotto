package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringToLottoNumbersTest {
    @Test
    @DisplayName("input이 숫자로 넘어오지 않으면 에러")
    void test1() {
        String input = "asdf";
        assertThatThrownBy(() -> StringToLottoNumbers.of(input))
                .hasMessageContaining("숫자로 변환할 수 없는 input입니다.");
    }
}