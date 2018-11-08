package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import lotto.utils.RandomNumberGenerator;

public class RandomNumberGeneratorTest {
    
    @Test
    public void 랜덤값_생성_성공() {
        int MAX_RANGE = 45;

        assertThat(RandomNumberGenerator.nextInt(MAX_RANGE)).isBetween(1, MAX_RANGE);
    }

    @Test
    public void 랜덤값_최소_최대값_검증() {
        int MAX_RANGE = 45;
        int[] values = new int[20];

        for (int i = 0; i < values.length; i++) {
            assertThat(RandomNumberGenerator.nextInt(MAX_RANGE)).isBetween(1, MAX_RANGE);
        }

    }
}
