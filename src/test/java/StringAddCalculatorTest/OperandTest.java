package StringAddCalculatorTest;

import stringaddcalculator.Operand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class OperandTest {
    @Test
    void Given_InitialNumber_When_New_Then_InstanceCreated() {
        //given
        int initialNumber = 10;

        //when
        Operand actual = new Operand(10);

        //then
        assertThat(actual).isEqualTo(new Operand(10));
    }

    @Test
    void When_getInt_Then_ReturnInt() {
        //given
        Operand operand = new Operand(10);

        //when
        int actual = operand.getNumber();

        //then
        assertThat(actual).isEqualTo(10);
    }

    @Test
    void When_Add_Then_Added() {
        //given
        Operand o0 = new Operand(1);

        //when
        Operand actual = o0.add(new Operand(2));

        //then
        assertThat(actual).isEqualTo(new Operand(3));
    }

    @Test
    void Given_NegativeNumber_When_New_Then_RuntimeException() {
        int given = -1;
        assertThatThrownBy(() -> new Operand(given))
                .isInstanceOf(RuntimeException.class);
    }
}
