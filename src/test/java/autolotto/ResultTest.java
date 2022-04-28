package autolotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void matchCountGiven_ReturnBoolean() {
        assertThat(new Result(3, 5000).isMatch(3)).isTrue();
    }

    @Test
    void ReturnPrize() {
        assertThat(new Result(3, 5000, 3).prize()).isEqualTo(15000);
    }
}
