package lotto.validator;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberValidatorTest {

    private static final String WRONG_COUNT_EXCEPTION_MESSAGE = "로또는 6개의 숫자를 가져야합니다.";
    private static final String DUPLICATED_NUMBER_EXCEPTION_MESSAGE = "로또의 숫자는 중복되지 않아야합니다.";
    private static final String STRING_NUMBER_WRONG_CHARACTER = "문자열로 로또 번호를 입력한 경우 숫자, 공백, 콤마(,)만을 포함해야합니다.";

    @Test
    @DisplayName("리스트의 숫자가 6개가 아니면 Exception을 발생시킨다.")
    void exceptionTest1() {
        List<Integer> numbers = Lists.list(1, 2, 3, 4, 5, 6, 7);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> LottoNumberValidator.validate(numbers));
        assertThat(exception.getMessage()).isEqualTo(WRONG_COUNT_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("리스트가 중복된 값을 가지고 있으면 Exception을 발생시킨다.")
    void exceptionTest2() {
        List<Integer> numbers = Lists.list(1, 2, 3, 4, 6, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> LottoNumberValidator.validate(numbers));
        assertThat(exception.getMessage()).isEqualTo(DUPLICATED_NUMBER_EXCEPTION_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("문자열 로또 번호가 숫자, 공백, 콤마 외의 기호를 포함할 경우 Exception을 발생시킨다.")
    @ValueSource(strings = {"1, 2, 3; 4, 5, 6", "1, 2, 3, 4, a, 5", "1, 2, 3, *. 5, 6"})
    void exceptionTest3(String numbers) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> LottoNumberValidator.validate(numbers));
        assertThat(exception.getMessage()).isEqualTo(STRING_NUMBER_WRONG_CHARACTER);
    }

}
