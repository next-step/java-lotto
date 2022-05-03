package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("strategy를 입력하면 로또 번호를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void createNewNumberTest(int number) {
        assertThat(LottoNumber.createNewNumber(() -> number))
                .isEqualTo(LottoNumber.createNewNumber(() -> number));
    }

    @DisplayName("정수를 입력받아 로또 번호를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void createNewNumberFromUserInputTest(int number) {
        assertThat(LottoNumber.createNewNumber(number))
                .isEqualTo(LottoNumber.createNewNumber(() -> number));
    }

    @DisplayName("입력 범위를 벋어나는 정수로 로또 번호를 생성할 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createNewNumberFromUserInputTestFail(int number) {
        assertThatThrownBy(() -> createNewNumberFromUserInputTest(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}