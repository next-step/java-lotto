package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ManualCountTest {

    @Test
    void 뺄샘이_가능하다() {
        ManualCount manualCount = new ManualCount(5);

        int actual = manualCount.minus(10);
        int expected = 5;

        assertThat(actual).isEqualTo(expected);
    }

}
