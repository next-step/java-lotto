package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {


    @Test
    @DisplayName("중복된 숫자 예외처리")
    public void duplicationTest() {

        List<Number> duplication = Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(5)
        );

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(duplication);
        });
    }


    @Test
    @DisplayName("6개의 숫자보다 많을 경우 예외처리")
    public void tooManyNumberExceptionTest() {

        List<Number> tooMany = Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6),
                new Number(7)
        );

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(tooMany);
        });
    }

    @Test
    @DisplayName("6개의 숫자보다 적을 경우 예외처리")
    public void lessThanSixNumberExceptionTest() {

        List<Number> tooSmall = Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5)
        );
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(tooSmall);
        });
    }
}