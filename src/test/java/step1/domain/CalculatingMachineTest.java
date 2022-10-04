package step1.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatingMachineTest {

    @Test
    @DisplayName("생성 테스트")
    void cacluatingMachine_ctor_test() {
        Numbers numbers = new Numbers(
            List.of(
                new Number(1),
                new Number(3)
            )
        );

        Operators operators = new Operators(
            List.of(
            new Operator('+')
        ));

        assertThatNoException().isThrownBy(() -> new CalculatingMachine(numbers, operators));
    }

    @Test
    @DisplayName("연산 테스트")
    void calculate_test() {
        //given
        Numbers numbers = new Numbers(
            List.of(
                new Number(1),
                new Number(4),
                new Number(10),
                new Number(3)
            )
        );

        Operators operators = new Operators(
            List.of(
                new Operator('+'),
                new Operator('+'),
                new Operator('/')
            ));
        CalculatingMachine calculatingMachine = new CalculatingMachine(numbers, operators);

        //when
        Number number = calculatingMachine.calculation();

        //then
        assertThat(number).isEqualTo(new Number(5));

    }


}