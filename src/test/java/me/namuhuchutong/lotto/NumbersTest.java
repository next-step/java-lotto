package me.namuhuchutong.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import me.namuhuchutong.lotto.domain.Number;
import me.namuhuchutong.lotto.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @DisplayName("로또 숫자는 6개이다")
    @Test
    void lotto_numbers_should_be_six() {
        //given
        List<Number> given = List.of(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)
        );

        //when
        Numbers numbers = new Numbers(given);

        //then
        assertThat(numbers.size()).isEqualTo(6);
    }
    
    @DisplayName("로또 숫자가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_numbers_is_not_six() {
        //given
        List<Number> numbers = List.of(new Number(1));

        //when, then
        assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자들 중에 중복이 존재할 경우 예외가 발생한다.")
    @Test
    void throw_exception_when_duplicated_values_exist() {
        //given
        List<Number> given = List.of(
                new Number(1),
                new Number(1),
                new Number(1),
                new Number(1),
                new Number(1),
                new Number(1)
        );

        //when, then
        assertThatThrownBy(() -> new Numbers(given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("일치하는 번호들이 있다면 개수를 세어 반환한다.")
    @Test
    void return_lotto_match_count() {
        //given
        List<Number> given1 = List.of(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)
        );
        List<Number> given2 = List.of(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(32),
                new Number(5),
                new Number(13)
        );
        int expected = 4;
        Numbers numbers1 = new Numbers(given1);
        Numbers numbers2 = new Numbers(given2);

        //when
        long result = numbers1.howManyMatch(numbers2);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
