package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoRankTest {
    @Test
    @DisplayName("로또 번호의 갯수보다 더 많은 수의 당첨이 되면 예외가 발생한다.")
    void invalidMatchedNumberTest() {
        assertThatThrownBy(() -> LottoRank.fromMatchedNum(7))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
