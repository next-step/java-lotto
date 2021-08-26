package edu.nextstep.lottobonusnumber.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PrizeTest {
    @ParameterizedTest(name = "Prize enum 정적 팩토리 생성자 Test [{index}] {0}, {1}")
    @CsvSource({"6, false, FIRST", "5, true, SECOND", "5, false, THIRD", "4, false, FOURTH", "3, false, FIFTH", "0, false, LOSE"})
    void of(int countOfMatching, boolean hasBonusNumber, Prize checkPrize) {
        // when
        Prize prize = Prize.of(countOfMatching, hasBonusNumber);

        // then
        Assertions.assertThat(prize).isEqualTo(checkPrize);
    }
}
