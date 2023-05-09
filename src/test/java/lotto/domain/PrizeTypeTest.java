package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PrizeTypeTest {

    @Test
    void prizeTypeTest_findPrizeType() {
        assertThat(PrizeType.findPrizeType(3)).isEqualTo(PrizeType.THREE);
    }

    @Test
    void prizeTypeTest_findPrizeType_not_match() {
        assertThat(PrizeType.findPrizeType(2)).isNull();
    }
}