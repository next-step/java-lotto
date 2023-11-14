import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostfixTest {

    @DisplayName("공백이 제거된 인픽스 문자열을 포스트픽스 문자열로 바꾼다.")
    @Test
    void translateToNoneBlankStringToPostfixString(){
        String actual = Postfix.of("1236+-+").postfixString();
        assertThat(actual).isEqualTo("1236+-+");
    }

}
