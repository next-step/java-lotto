package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DivisionTest {
    private Division division;

    @BeforeEach
    void setUp() {
        division = new Division();
    }

    @Test
    void 나눗셈() {
        assertThat(division.apply(4, 2))
            .isEqualTo(2);
    }

    @Test
    void 나눗셈의결과가_정수로떨어지지않으면_IllegalArgumentException을던진다() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> division.apply(4, 3))
            .withMessage("나눗셈의 결과가 정수로 떨어지지 않습니다.");
    }

    @Test
    void _0으로나누면_IllegalArgumentException을던진다() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> division.apply(10, 0))
            .withMessage("0으로 나눌 수 없습니다.");
    }
}