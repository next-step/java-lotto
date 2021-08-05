package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void 문자배열을_입력받아서_계산기능시_결과를_확인한다(){
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.addEachAll(new String[]{"1", "2", "3"});
        //then
        assertThat(result).isEqualTo(6);
    }
}
