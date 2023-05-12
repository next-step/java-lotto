package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.*;

class LottoTest {
    @Test
    @DisplayName("보너스 번호 일치 여부 확인")
    void match_bonus() {
        // given
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        // when, then
        assertSoftly(softly -> {
            softly.assertThat(lotto.matchBonus(new BonusNumber(1))).isTrue();
            softly.assertThat(lotto.matchBonus(new BonusNumber(7))).isFalse();
        });
    }
}