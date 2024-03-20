package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    @DisplayName("findByCorrectCount 호출 시 파라미터(3~6)에 따라 적합한 LottoRank 반환")
    void findByCorrectCount() {
        assertAll(
                () -> assertThat(LottoRank.findByCorrectCount(2)).isEmpty(),
                () -> assertThat(LottoRank.findByCorrectCount(3).get()).isEqualTo(LottoRank.THREE_NUMBER_CORRECT),
                () -> assertThat(LottoRank.findByCorrectCount(4).get()).isEqualTo(LottoRank.FOUR_NUMBER_CORRECT),
                () -> assertThat(LottoRank.findByCorrectCount(5).get()).isEqualTo(LottoRank.FIVE_NUMBER_CORRECT),
                () -> assertThat(LottoRank.findByCorrectCount(6).get()).isEqualTo(LottoRank.SIX_NUMBER_CORRECT)
        );
    }
}