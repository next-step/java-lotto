package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperatorsTest {

    private static final List<String> OPERATORS = Arrays.asList("+","-","*","/");

    private static final List<String> INVALID_OPERATORS = Arrays.asList("#","?");

    private static final List<String> EMPTY_ARRAY = new ArrayList<>();

    private Operators operators;

    @BeforeEach
    void setUp() {
        operators = new Operators(OPERATORS);
    }

    @Test
    @DisplayName("숫자타입의 문자열 인입시 객체를 정상 생성한다.")
    void createObjTest() {
        assertThat(operators).isNotNull();
    }

    @Test
    @DisplayName("사칙연산에 위배되는 연산자 인입시 익셉션을 발생한다.")
    void createErrorTest() {
        assertThatThrownBy(() -> new Operators(INVALID_OPERATORS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 연산기호가 아닙니다.");
    }

    @Test
    @DisplayName("null 인입 시 익셉션을 발생한다.")
    void nullInitTest() {
        assertThatThrownBy(() -> new Operators(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 연산기호가 아닙니다.");
    }

    @Test
    @DisplayName("연산기호 인입 후 자료값을 Queue 로 리턴한다.")
    void getOperatorsTest() {
        Queue<String> operators = new LinkedList<>(OPERATORS);
        assertThat(this.operators.operators()).isEqualTo(operators);
    }
}
