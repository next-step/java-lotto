package edu.nextstep.lottoauto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    void of() {
        // given
        int countOfMatching = 6;

        // when
        Prize prize = Prize.of(countOfMatching);

        // then
        Assertions.assertThat(prize).isEqualTo(Prize.FIRST);
    }
}