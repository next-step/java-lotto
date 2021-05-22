package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"3,false,FIFTH", "4,false,FOURTH", "5,false,THIRD", "5,true,SECOND", "6,false,FIRST"})
    @DisplayName("일치하는 개수와 보너스 여부 입력 시 당첨 등수를 반환한다")
    void findPrizeByMatchCountAndBonusTest(int matchCount, boolean bonus, Prize expected) {
        Prize prize = Prize.valueOf(matchCount, bonus);
        assertThat(prize).isEqualTo(expected);
    }
}