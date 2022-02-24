package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void 당첨개수_3개_미만은_보너스와_상관없이_보상이_없다() {
        assertAll(
            () -> assertThat(LottoResult.of(1, true)).isEqualTo(LottoResult.NO_REWARD),
            () -> assertThat(LottoResult.of(2, true)).isEqualTo(LottoResult.NO_REWARD)
        );
    }

    @Test
    void 당첨개수_3개라면_THREE_MATCHING을_반환한다() {
        assertAll(
            () -> assertThat(LottoResult.of(3, true)).isEqualTo(LottoResult.THREE_MATCHING),
            () -> assertThat(LottoResult.of(3, false)).isEqualTo(LottoResult.THREE_MATCHING)
        );
    }

    @Test
    void 당첨개수_4개라면_FOUR_MATCHING_반환() {
        assertAll(
            () -> assertThat(LottoResult.of(4, true)).isEqualTo(LottoResult.FOUR_MATCHING),
            () -> assertThat(LottoResult.of(4, false)).isEqualTo(LottoResult.FOUR_MATCHING)
        );
    }

    @Test
    void 당첨개수_5개라면_보너스여부를_반영해서_FIVE_MATCHING_반환() {
        assertAll(
            () -> assertThat(LottoResult.of(5, true)).isEqualTo(LottoResult.FIVE_MATCHING_BONUS),
            () -> assertThat(LottoResult.of(5, false)).isEqualTo(LottoResult.FIVE_MATCHING)
        );
    }

    @Test
    void 당첨개수_6개라면_SIX_MATCHING_반환() {
        assertAll(
            () -> assertThat(LottoResult.of(6, true)).isEqualTo(LottoResult.SIX_MATCHING),
            () -> assertThat(LottoResult.of(6, false)).isEqualTo(LottoResult.SIX_MATCHING)
        );
    }
}
