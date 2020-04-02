package lotto2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @DisplayName("당첨번호의 일치 갯수와 당첨 금액을 보여준다.  ")
    @Test
    void testPrizeMatchAmount() {
        assertThat(Prize.FIRST).isEqualTo(Prize.of(6));
        assertThat(Prize.FIRST.getAmount()).isEqualTo(200_000_0000);
    }
}
