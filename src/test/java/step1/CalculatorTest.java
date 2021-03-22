package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    public void add_many() {
        //given
        Integer[] inputNumbers = new Integer[]{1,2,3};
        int expectResult = 6;


        //when
        int result = Calculator.add(inputNumbers);


        //then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    public void add_one() {
        //given
        Integer[] inputNumbers = new Integer[]{3};
        int expectResult = 3;

        //when
        int result = Calculator.add(inputNumbers);


        //then
        assertThat(result).isEqualTo(expectResult);
    }
}
