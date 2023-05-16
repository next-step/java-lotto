import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTest {

    @DisplayName("연산자 기호로 연산자 enum을 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void fromSignature(String signature) {
        //when
        Operator operator = Operator.fromSignature(signature);
        //then
        assertThat(operator).isIn(Operator.values());
    }

    @DisplayName("연산자 기호 이외의 값으로 연산자 생성시 오류를 반환한다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {" ", "null", "plus"})
    void returnException_whenValueIsNotOperatorSignature(String input) {
        //when & then
        assertThatThrownBy(() -> {
            Operator operator = Operator.fromSignature(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}