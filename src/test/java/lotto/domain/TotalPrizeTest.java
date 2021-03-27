package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalPrizeTest {

    @Test
    @DisplayName("총 당첨 금액 생성")
    public void create() throws Exception {
        TotalPrize totalPrize = new TotalPrize(1000);
        assertThat(totalPrize).isEqualTo(new TotalPrize(1000));
    }
}
