package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveNumberTest {

    private final PositiveNumber positiveNumber;

    public PositiveNumberTest() {
        this.positiveNumber = new PositiveNumber();
    }

    @DisplayName("숫자 변환 테스트")
    @Test
    void toInt() {
        //given
        String[] stringNumbers = {"1", "2", "3", "4"};

        //when
        List<Integer> numbers = positiveNumber.toInt(stringNumbers);

        //then
        assertThat(numbers).contains(1, 2, 3, 4);
    }

    @DisplayName("더하기 테스트")
    @Test
    void add() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        //when
        int result = positiveNumber.sum(numbers);

        //then
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("숫자가 아닌 값 검증 테스트")
    @Test
    void isNumber() {
        //given
        String[] stringNumbers = {"1", "2", "^"};

        assertThatThrownBy(() -> {
            positiveNumber.toInt(stringNumbers);
        }).isInstanceOf(RuntimeException.class).hasMessageMatching("숫자가 아닌 입력값이 존재합니다.");
    }

    @DisplayName("음수 검증 테스트")
    @Test
    void isNegative() {
        //given
        List<Integer> numbers = List.of(-1, 2, 3, 4, 5);

        assertThatThrownBy(() -> {
            positiveNumber.sum(numbers);
        }).isInstanceOf(RuntimeException.class).hasMessageMatching("양수만 덧셈이 가능합니다.");

    }
}