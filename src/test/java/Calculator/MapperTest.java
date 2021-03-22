package Calculator;

import org.junit.jupiter.api.Test;

import static Calculator.Delimiter.DEFAULT_DELIMETER;
import static org.assertj.core.api.Assertions.assertThat;

public class MapperTest {

    @Test
    void operandToIntTest(){
        //given
        int testNum = 1;
        Operand operand = new Operand(testNum);

        //when
        int result = Mapper.operandToInt(operand);

        //then
        assertThat(result).isEqualTo(testNum);
    }

    @Test
    void delimiterToStringTest(){
        //given
        String testDel = DEFAULT_DELIMETER;
        Delimiter delimiter = new Delimiter();

        //when
        String result = Mapper.delimiterToString(delimiter);

        //then
        assertThat(result).isEqualTo(testDel);
    }
}
