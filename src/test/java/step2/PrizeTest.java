package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Prize;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class PrizeTest {

    @Test
    void prizeTest() {
        assertThat(Prize.calculatorYield(Arrays.asList(5, 0, 0, 0, 0, 0, 1), 6000)).isEqualTo(2000000000D/6000D);
    }
}
