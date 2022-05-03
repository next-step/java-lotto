package autolotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void matchCountGiven_ReturnBoolean() {
        assertThat(new Result(3, false).isMatch(3)).isTrue();
    }
}
