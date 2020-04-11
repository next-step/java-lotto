package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PrizeTest {

    @DisplayName("당첨번호의 일치 갯수와 당첨 금액을 보여준다.  ")
    @Test
    void testPrizeMatchAmount() {
        assertAll(
                () -> assertThat(Prize.FIRST).isEqualTo(Prize.of(6, false)),
                () -> assertThat(Prize.FIRST.getAmount()).isEqualTo(200_000_0000)
        );
    }

    @DisplayName("2등의 일치 갯수와 당첨 금액을 보여준다. ")
    @Test
    void testPrizeSecondAmount() {
        assertAll(
                () -> assertThat(Prize.SECOND).isEqualTo(Prize.of(5, true)),
                () -> assertThat(Prize.SECOND.getAmount()).isEqualTo(30_000_000)
        );
    }
}
