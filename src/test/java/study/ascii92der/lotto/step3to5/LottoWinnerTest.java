package study.ascii92der.lotto.step3to5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinnerTest {

    @Test
    @DisplayName("로또 성적 별 결과 확인")
    void valueOf() {
        assertAll(
                () -> assertThat(LottoWinner.valueOf(6, false)).isEqualTo(LottoWinner.FIRST),
                () -> assertThat(LottoWinner.valueOf(5, true)).isEqualTo(LottoWinner.SECOND),
                () -> assertThat(LottoWinner.valueOf(5, false)).isEqualTo(LottoWinner.THIRD),
                () -> assertThat(LottoWinner.valueOf(4, false)).isEqualTo(LottoWinner.FOURTH),
                () -> assertThat(LottoWinner.valueOf(3, false)).isEqualTo(LottoWinner.FIFTH),
                () -> assertThat(LottoWinner.valueOf(0, false)).isEqualTo(LottoWinner.MISS)
        );

    }
}