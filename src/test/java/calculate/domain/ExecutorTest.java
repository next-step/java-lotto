package calculate.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExecutorTest {

    @Test
    @DisplayName("3 더하기 2는 5의 계산결과가 나온다")
    void calculate1() {
        assertThat(new Executor("3 + 2").calculate()).isEqualTo(5);
    }

    @Test
    @DisplayName("3 더하기 2 빼기 1 곱하기 4는 16의 계산결과가 나온다")
    void calculate2() {
        assertThat(new Executor("3 + 2 - 1 * 4").calculate()).isEqualTo(16);
    }
}