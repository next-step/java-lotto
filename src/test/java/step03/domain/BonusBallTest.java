package step03.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusBallTest {

    @DisplayName("생성자")
    @Test
    void test_constructor() {
        assertThat(BonusBall.of(LottoBall.valueOf(1)))
                .isEqualTo(BonusBall.of(LottoBall.valueOf(1)));
    }

}
