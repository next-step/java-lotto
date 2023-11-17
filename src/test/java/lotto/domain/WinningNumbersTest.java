package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

        @Test
        void 당첨번호를_6개_이상_입력했을_경우_에러() {
                assertThatThrownBy(() -> new WinningNumbers(new int[]{1, 2, 3, 4, 5, 6, 7})).isInstanceOf(
                    IllegalArgumentException.class).hasMessage("6개의 당첨번호를 중복되지않게 입력해주세요.");
        }
}
