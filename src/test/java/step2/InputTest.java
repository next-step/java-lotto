package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Prize;
import step2.validation.InputViewValidator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 300, 400, 500})
    void inputWrongOperator(int data) {

        Prize prize = new Prize();

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputViewValidator.prizeCountValidate(prize.getLottoCount(data));
                });
    }
}
