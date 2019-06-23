package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @DisplayName("로또 번호가 일치하는 개수에 따른 당첨결과를 반환한다")
    @ParameterizedTest
    @CsvSource({
            "6, FIRST",
            "5, SECOND",
            "4, THIRD",
            "3, FOURTH",
            "2, NONE",
            "1, NONE",
            "0, NONE",
    })
    void prize(int matchCount, Prize prize) {
        assertThat(Prize.of(matchCount)).isEqualTo(prize);
    }
}
