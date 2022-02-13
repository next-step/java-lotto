package lotto.domain.result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.dto.WinningInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoResultTest {

    @Test
    void 당첨결과를_찾지_못할_경우_예외처리() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LottoResult.of(new WinningInfo(7, false)))
            .withMessage("[ERROR] 당첨 결과를 찾지 못했습니다.");
    }

    @Test
    void 보너스볼과_관련_없는_당첨_확인_3_4_6() {

        assertAll(
            () -> assertThat(LottoResult.of(new WinningInfo(3, true)))
                .isEqualTo(LottoResult.THREE_MATCHING),
            () -> assertThat(LottoResult.of(new WinningInfo(4, true)))
                .isEqualTo(LottoResult.FOUR_MATCHING),
            () -> assertThat(LottoResult.of(new WinningInfo(6, true)))
                .isEqualTo(LottoResult.SIX_MATCHING)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 당첨개수_3_미만일_때_상금_없음(int count) {

        assertAll(
            () -> assertThat(LottoResult.of(new WinningInfo(count, true)))
                .isEqualTo(LottoResult.NO_REWARD),
            () -> assertThat(LottoResult.of(new WinningInfo(count, false)))
                .isEqualTo(LottoResult.NO_REWARD)
        );
    }
}
