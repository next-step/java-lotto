package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @DisplayName("로또 번호가 일치하는 개수에 따른 당첨결과를 반환한다")
    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true,  SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, NONE",
            "0, false, NONE",
    })
    void resultByMatchCount(int matchCount, boolean existBonus, Prize prize) {
        assertThat(Prize.of(matchCount, existBonus)).isEqualTo(prize);
    }
}
