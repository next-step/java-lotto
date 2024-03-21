package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {
    @Test
    void 로또_번호_생성() {
        assertThat(RandomUtil.getRandom()).isBetween(1,45);
    }
}
