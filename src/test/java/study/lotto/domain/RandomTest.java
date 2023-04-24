package study.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RandomTest {
    @Test
    void 랜덤_숫자_테스트() {
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int value = random.nextInt(10);
            assertThat(value).isBetween(0, 10);
        }
    }
}
