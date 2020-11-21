package step03.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBallTest {

    @DisplayName("생성자")
    @Test
    void test_constructor() {
        assertThat(LottoBall.of(1)).isEqualTo(LottoBall.of(1));
    }

}
