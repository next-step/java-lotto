package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class NumbersTest {

    private static final String [] NUMBERS = {"1","2","3","4"};


    private Numbers numbers;

    @BeforeEach
    void setUp() {
        numbers = new Numbers(NUMBERS);
    }

    @Test
    @DisplayName("숫자타입의 문자열 인입시 객체를 정상 생성한다.")
    void createObjTest() {
        assertThat(numbers).isNotNull();
    }

    @ParameterizedTest(name = "숫자 배열의 값이 비어있는 경우 예외가 발생한다.")
    @NullAndEmptySource
    void createObjExceptionTest(String [] emptySource) {
        assertThatThrownBy(() -> new Numbers(emptySource))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산 가능한 숫자가 없습니다.");
    }

    @ParameterizedTest(name = "숫자 배열의 값이 비어있는 경우 예외가 발생한다.")
    @NullAndEmptySource
    void createObjExceptionTest(int [] emptySource) {
        assertThatThrownBy(() -> new Numbers(emptySource))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산 가능한 숫자가 없습니다.");
    }

    @Test
    @DisplayName("숫자 타입 인입 후 해당 자료구조를 Queue 로 리턴한다")
    void getNumbersQueueTest() {
        Queue<Integer> expected = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
        assertThat(numbers.numbers()).isEqualTo(expected);
    }
}
