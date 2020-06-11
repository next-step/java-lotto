package camp.nextstep.edu.nextstep8.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoAwardTest {
    @DisplayName("조건에 맞는 컨디션 반환")
    @Test
    public void ofTest() {
        // given
        int condition = 6;

        // when & then
        assertThat(LottoAward.of(condition)).isEqualTo(LottoAward.FIRST);
    }

    @DisplayName("조건에 맞는 컨디션이 없을 경우 null 반환")
    @Test
    public void ofNullTest() {
        // given
        int condition = 99;

        // when & then
        assertThat(LottoAward.of(condition)).isNull();
    }
}
