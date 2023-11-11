package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    @DisplayName("문자형 숫자를 입력받아도 정수로 바꿔서 리스트에 추가한다.")
    void addNumber() {
        // given
        String element = "-1";
        Numbers numbers = new Numbers();
        // when
        numbers.addNumber(element);
        // then
        assertThat(numbers).isEqualTo(new Numbers(List.of(-1)));
    }

    @Test
    @DisplayName("numbers 목록에 아무런 숫자가 없다면 false를 반환합니다.")
    void noElement() {
        // given
        Numbers trueNumbers = new Numbers();
        Numbers falseNumbers = new Numbers();
        falseNumbers.addNumber("1");
        // when
        boolean result1 = trueNumbers.hasNumber();
        boolean result2 = falseNumbers.hasNumber();
        // then
        assertThat(result1).isFalse();
        assertThat(result2).isTrue();
    }

}