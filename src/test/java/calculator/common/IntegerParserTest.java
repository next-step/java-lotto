package calculator.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntegerParserTest {
    @Test
    public void 문자열을_받아서_integer로_변환할_수_있다(){
        //given
        //when
        IntegerParser parser = new IntegerParser();
        //then
        assertThat(parser.parse("1")).isEqualTo(1);
    }

    @Test
    public void 문자열을_파싱할_수_없을_때_RuntimeException이_발생한다(){
        //given
        //when
        IntegerParser parser = new IntegerParser();
        //then
        assertThatThrownBy(() -> parser.parse("~"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("잘못된 인자를 전달하였습니다.");
    }
    @Test
    public void 음수를_파싱할때_RuntimeException이_발생한다(){
        //given
        //when
        IntegerParser parser = new IntegerParser();
        //then
        assertThatThrownBy(() -> parser.parse("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수는 사용할 수 없습니다.");
    }


}
