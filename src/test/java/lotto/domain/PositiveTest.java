package lotto.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositiveTest {

    @Test
    @DisplayName("Positive 생성, 동일 값 비교 테스트")
    void positive() {
        Positive positive = new Positive("1");
        assertThat(positive).isEqualTo(new Positive("1"));
    }

    @Test
    @DisplayName("음수 사용 시 예외 발생")
    void negative() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    new Positive("-1");
                });
    }

    @Test
    @DisplayName("Positive + int 더하기 검증")
    void plus_int() {
        Positive positive = new Positive("1");
        int number = 2;

        Positive result = positive.plus(number);

        assertThat(result).isEqualTo(new Positive("3"));
    }

    @Test
    @DisplayName("Positive + Positive 더하기 검증")
    void plus_positive() {
        Positive positive = new Positive("1");
        Positive positive2 = new Positive("2");

        Positive result = positive.plus(positive2);

        assertThat(result).isEqualTo(new Positive("3"));
    }

    @Test
    @DisplayName("빼기 검증")
    void minus() {
        Positive result = new Positive(2).minus(1);

        assertThat(result).isEqualTo(new Positive(1));
    }

    @Test
    @DisplayName("빼기 실패")
    void minus_fail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Positive(1).minus(new Positive(2)));
    }

    @Test
    @DisplayName("Positive 빼기 검증")
    void minus_positive() {
        Positive result = new Positive(2).minus(new Positive(1));

        assertThat(result).isEqualTo(new Positive(1));
    }

    @Test
    @DisplayName("나누기 검증")
    void divide() {
        Positive result = new Positive(10).divide(2);

        assertThat(result).isEqualTo(new Positive(5));
    }

    @Test
    @DisplayName("Positive 나누기 검증")
    void divide_positive() {
        Positive result = new Positive(10).divide(new Positive(2));

        assertThat(result).isEqualTo(new Positive(5));
    }
}
