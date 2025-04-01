package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {
    @DisplayName("로또번호 일치 개수와 보너스 일치 여부로 몇등인지 알 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "0, false, MISS",
            "1, false, MISS",
            "2, true, MISS",
            "3, true, FIFTH",
            "4, true, FOURTH",
            "5, false, THIRD", "5, true, SECOND",
            "6, false, FIRST"
    })
    void valueOfTest(int matchCount, boolean bonus, Rank expected) {
        Rank rank = Rank.valueOf(matchCount, bonus);

        assertThat(rank).isEqualTo(expected);
    }

    @DisplayName("상금을 계산한다.")
    @Test
    void calculatePrizeTest() {
        assertThat(Rank.FOURTH.calculatePrize(4)).isEqualTo(200_000);
    }
}
