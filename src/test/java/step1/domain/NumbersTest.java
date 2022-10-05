package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayDeque;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    @DisplayName("생성 테스트")
    void numbers_ctor_test() {
        assertThatNoException()
            .isThrownBy(() -> new Numbers(
                new ArrayDeque<>(List.of(new Number(5)))
            ));
    }

    @Test
    @DisplayName("숫자 하나씩 가져오기 테스트")
    void get_number_test() {
        //given
        List<Number> numberList = List.of(
            new Number(5),
            new Number(6)
        );

        Numbers numbers = new Numbers(
            new ArrayDeque<>(numberList)
        );

        //when
        Number number = numbers.pollNumber();

        //then
        assertThat(number).isEqualTo(new Number(5));
    }

    @Test
    @DisplayName("숫자를 추가로 가져오면 예외가 발생한다.")
    void over_get_number_throw_exception_test() {
        //given
        List<Number> numberList = List.of(
            new Number(5)
        );
        Numbers numbers = new Numbers(numberList);

        //when
        numbers.pollNumber();

        //then
        assertThatThrownBy(numbers::pollNumber)
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("더 이상 숫자가 존재하지 않습니다.");
    }
}