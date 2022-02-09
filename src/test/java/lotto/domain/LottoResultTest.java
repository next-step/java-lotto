package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 순위_테스트() {
        LottoResult from = LottoResult.from(5, true);
        assertThat(from).isEqualTo(LottoResult.FIVE_MATCHING_BONUS);
    }

    @Test
    void 당첨_결과_예외_테스트() {
        assertThatThrownBy(() -> LottoResult.from(7, false))
            .isInstanceOf(IllegalArgumentException.class);
    }
}