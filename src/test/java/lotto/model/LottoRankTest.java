package lotto.model;

import common.model.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @ParameterizedTest
    @CsvSource(value = {"6,2000000000", "5,30000000", "4,50000", "3,5000"})
    @DisplayName("로또 당첨금 확인 테스트")
    void lottoAmount(int matchCount, int amount) {
        assertThat(LottoRank.valueOf(new Number(matchCount)).getAmount()).isEqualTo(amount);
    }

    @Test
    @DisplayName("2등 테스트")
    void second() {
        Number number = new Number(5);
        assertThat(LottoRank.valueOf(number, true)).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("3등 테스트")
    void third() {
        Number number = new Number(5);
        assertThat(LottoRank.valueOf(number, false)).isEqualTo(LottoRank.THIRD);
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    @DisplayName("4등 테스트")
    void fourth(boolean isBonus) {
        Number number = new Number(4);
        assertThat(LottoRank.valueOf(number, isBonus)).isEqualTo(LottoRank.FOURTH);

    }
}