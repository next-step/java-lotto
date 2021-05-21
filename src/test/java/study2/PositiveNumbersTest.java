package study2;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import study2.domain.PositiveNumbers;

public class PositiveNumbersTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        // given
        String[] test = "1,2,3".split(",");
        // when
        PositiveNumbers positiveNumbers = PositiveNumbers.of(test);
        // then
        assertThat(positiveNumbers).isEqualTo(PositiveNumbers.of(Arrays.asList("1", "2", "3")));
    }

    @Test
    @DisplayName("합계 테스트")
    void sum() {
        // given
        PositiveNumbers positiveNumbers = PositiveNumbers.of(Arrays.asList("1", "2", "3"));
        // when & then
        assertThat(positiveNumbers.sum()).isEqualTo(6);
    }

}
