package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    public void add_many() {
        //given
        int[] inputNumbers = new int[]{1,2,3};
        int expectResult = 6;


        //when
        int result = Calculator.add(inputNumbers);


        //then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    public void add_one() {
        //given
        int[] inputNumbers = new int[]{3};
        int expectResult = 3;

        //when
        int result = Calculator.add(inputNumbers);


        //then
        assertThat(result).isEqualTo(expectResult);
    }
}
