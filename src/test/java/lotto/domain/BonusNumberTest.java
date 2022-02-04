package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호 정상 생성.")
    @Test
    void 생성자() {
        // given
        String input = "7";

        // then
        assertDoesNotThrow(() -> new BonusNumber(input));
    }

    @DisplayName("숫자가 아닌 값이 들어왔을 때")
    @Test
    void isNotANumber() {
        // given
        String input = "aaa";

        // then
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(input));
    }

    @DisplayName("숫자 여러개가 들어왔을 때")
    @Test
    void 숫자_여러개가_들어왔을_때() {
        // given
        String input = "1 2";

        // then
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(input));
    }

    @DisplayName("1 ~ 45 범위의 숫자인지 확인")
    @Test
    void isNumberRange1to45() {
        // given
        String input = "46";

        // then
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(input));
    }
}
