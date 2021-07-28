package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("NaturalNumber 테스트")
public class NaturalNumberTest {

    @DisplayName("숫자가 아닌 문자, null, 음수일 경우 RuntimeException이 발생한다")
    @ValueSource(strings = {"-1", "a"})
    @NullAndEmptySource
    @ParameterizedTest
    void must_throw_exception_not_natural_number(String input) {
        //arrange, act, assert
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> NaturalNumber.of(input));
    }

    @DisplayName("숫자 문자를 가지고 NaturalNumber 객체 생성 한다.")
    @ValueSource(strings = {"1", "2", "3"})
    @ParameterizedTest
    void should_create_natural_number_using_string_value(String input) {
        //arrange
        NaturalNumber naturalNumber = NaturalNumber.of(input);

        //act, assert
        assertThat(naturalNumber.toInt()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자 가지고 NaturalNumber 객체 생성 한다.")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void should_create_natural_number_using_string_value(int input) {
        //arrange
        NaturalNumber naturalNumber = NaturalNumber.of(input);

        //act, assert
        assertThat(naturalNumber.toInt()).isEqualTo(input);
    }

    @DisplayName("문자로 생성된 NaturalNumber는 덧셈이 가능하다")
    @Test
    void can_add_natural_number_created_string() {
        //arrange
        NaturalNumber naturalNumberOne = NaturalNumber.of("1");
        NaturalNumber naturalNumberTwo = NaturalNumber.of("2");
        NaturalNumber expect = NaturalNumber.of("3");

        //act
        NaturalNumber result = naturalNumberOne.add(naturalNumberTwo);

        //assert
        assertAll(
                () -> assertThat(result).isEqualTo(expect),
                () -> assertThat(result.toInt()).isEqualTo(expect.toInt())
        );
    }

    @DisplayName("숫자로 NaturalNumber는 덧셈이 가능하다")
    @Test
    void can_add_natural_number_created_int() {
        //arrange
        NaturalNumber naturalNumberOne = NaturalNumber.of(1);
        NaturalNumber naturalNumberTwo = NaturalNumber.of(2);
        NaturalNumber expect = NaturalNumber.of(3);

        //act
        NaturalNumber result = naturalNumberOne.add(naturalNumberTwo);

        //assert
        assertAll(
                () -> assertThat(result).isEqualTo(expect),
                () -> assertThat(result.toInt()).isEqualTo(expect.toInt())
        );
    }
}