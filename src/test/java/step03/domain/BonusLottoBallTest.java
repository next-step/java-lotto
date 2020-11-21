package step03.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusLottoBallTest {

    @DisplayName("생성자")
    @Test
    void test_constructor() {
        assertThat(BonusLottoBall.of(LottoBall.valueOf(1)))
                .isEqualTo(BonusLottoBall.of(LottoBall.valueOf(1)));
    }
}
