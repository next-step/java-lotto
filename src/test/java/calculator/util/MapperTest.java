package calculator.util;

import calculator.domain.Operand;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapperTest {

    @Test
    void operandToIntTest() {
        //given
        int testNum = 1;
        Operand operand = new Operand(testNum);

        //when
        int result = Mapper.operandToInt(operand);

        //then
        assertThat(result).isEqualTo(testNum);
    }
}
