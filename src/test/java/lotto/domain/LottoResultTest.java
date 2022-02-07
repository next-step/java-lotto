package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoResultTest {

    @Test
    void 당첨결과를_찾지_못할_경우_예외처리() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoResult.of(7, false))
            .withMessage("[ERROR] 당첨 결과를 찾지 못했습니다.");
    }

    @Test
    void 보너스볼과_관련_없는_당첨_확인_3_4_6() {
        assertThat(LottoResult.of(3, true))
            .isEqualTo(LottoResult.THREE_MATCHING);

        assertThat(LottoResult.of(4, true))
            .isEqualTo(LottoResult.FOUR_MATCHING);

        assertThat(LottoResult.of(6, true))
            .isEqualTo(LottoResult.SIX_MATCHING);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 당첨개수_3_미만일_때_상금_없음(int count) {
        assertThat(LottoResult.of(count, true))
            .isEqualTo(LottoResult.NO_REWARD);

        assertThat(LottoResult.of(count, false))
            .isEqualTo(LottoResult.NO_REWARD);
    }
}
