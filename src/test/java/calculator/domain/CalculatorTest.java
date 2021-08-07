package calculator.domain;

import calculator.common.IntegerParser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    public void 문자배열을_입력받아서_계산기능시_결과를_확인한다(){
        //given
        Calculator calculator = new Calculator();
        //when
        int result = calculator.addEachAll(new String[]{"1", "2", "3"}, new IntegerParser());
        //then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 잘못된_원소가_전달되면_RuntimeException이_발생한다(){
        //given
        Calculator calculator = new Calculator();
        //when
        //then
        assertThatThrownBy(() -> calculator.addEachAll(new String[]{"1", "2", "a"}, new IntegerParser()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("잘못된 인자를 전달하였습니다.");
    }

    @Test
    public void 음수의_원소가_전달되면_RuntimeException이_발생한다(){
        //given
        Calculator calculator = new Calculator();
        //when
        //then
        assertThatThrownBy(() -> calculator.addEachAll(new String[]{"1", "2", "-1"}, new IntegerParser()))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 사용할 수 없습니다.");
    }
}
