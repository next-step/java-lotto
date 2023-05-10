package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UtilTest {

    @Test
    void isNullOrEmpty() {
        assertThat(Util.isNullOrEmpty(null)).isTrue();
        assertThat(Util.isNullOrEmpty("")).isTrue();
        assertThat(Util.isNullOrEmpty("3")).isFalse();
    }
}
