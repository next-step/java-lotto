package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.util.PrizeCalculatorUtil;
import step2.validation.InputViewValidator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 300, 400, 500})
    void 금액_부족(int data) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                InputViewValidator.prizeCountValidate(PrizeCalculatorUtil.getLottoCount(data));
            });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,3,4,5,7,5,7,5,6,", "1,2,3", "11,44,22,23,44"})
    void 당첨번호_갯수_예외(String data) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputViewValidator.winningLottoValidate(data);
                });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 48, 500})
    void 당첨번호_번호_예외(int data) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputViewValidator.validateNumber(data);
                });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,1,2,3,4", "11,21,13,13,14,16", "11,44,22,23,44,22"})
    void 당첨번호_중복_입력(String data) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputViewValidator.winningLottoValidate(data);
                });
    }
}
