package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest(name = "x : {0} , y : {1}")
    @CsvSource(value = {"4,2", "6,3", "10,5"})
    void 나눗셈(int x, int y) {
        assertThat(division.apply(x, y)).isEqualTo(x / y);
    }

    @Test
    void 나눗셈_결과가_정수가_아니면_IllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> division.apply(4, 3))
                .withMessage("나눗셈의 경우 결과 값은 정수여야 합니다");
    }

    @Test
    void 나누는_수가_0이면_IllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> division.apply(10, 0))
                .withMessage("0으로 나눌 수 없습니다");
    }

}