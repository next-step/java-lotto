package edu.nextstep.lottoauto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {

    @ParameterizedTest(name = "Prize enum 정적 팩토리 생성자 Test [{index}] {0}, {1}")
    @CsvSource({"6, FIRST", "5, SECOND", "4, THIRD", "3, FOURTH", "0, NULL"})
    void of(int countOfMatching, Prize checkPrize) {
        // when
        Prize prize = Prize.of(countOfMatching);

        // then
        Assertions.assertThat(prize).isEqualTo(checkPrize);
    }
}