package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    @DisplayName("정렬된 로또 번호 반환")
    void numbers() {
        // given
        Lotto lotto = new Lotto(1, 6, 2, 5, 3, 4);

        // when, then
        assertThat(lotto.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}