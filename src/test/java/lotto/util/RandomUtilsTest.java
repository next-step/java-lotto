package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by seungwoo.song on 2022-10-06
 */
class RandomUtilsTest {

    @Test
    void 생성() {
        Integer number = RandomUtils.getNumber(45);

        for (int i = 0; i < 100000; i++) {
            assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
        }
    }
}