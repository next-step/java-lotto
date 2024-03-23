package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    @DisplayName("findByCorrectCount 호출 시 파라미터(3~6)에 따라 적합한 LottoRank 반환")
    void findByCorrectCount() {
        assertAll(
                () -> assertThat(LottoRank.findByCorrectCount(2, false)).isEmpty(),
                () -> assertThat(LottoRank.findByCorrectCount(3, false).get()).isEqualTo(LottoRank.FIFTH),
                () -> assertThat(LottoRank.findByCorrectCount(4, false).get()).isEqualTo(LottoRank.FOURTH),
                () -> assertThat(LottoRank.findByCorrectCount(5, false).get()).isEqualTo(LottoRank.THIRD),
                () -> assertThat(LottoRank.findByCorrectCount(6, false).get()).isEqualTo(LottoRank.FIRST)
        );
    }
}