package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static step2.PrizeType.findPrizeType;

class PrizeTypeTest {

    @Test
    void calculate() {
        assertThat(findPrizeType(3)).isEqualTo(PrizeType.THREE);
    }
}