package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPrizeTest {
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
    void valueOfBonusTest(int matchCount, boolean bonus, LottoPrize expected) {
        LottoPrize lottoPrize = LottoPrize.valueOf(matchCount, bonus);

        // then
        assertThat(lottoPrize).isEqualTo(expected);
    }
}
