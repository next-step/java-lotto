package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자만 가진다")
    public void splitAndSum_숫자하나() throws Exception {
        List<String> strings = Splitter.split("1");
        assertThat(strings).containsExactly("1");
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두개의 숫자를 가진다")
    public void splitAndSum_쉼표구분자() throws Exception {
        List<String> strings = Splitter.split("1,2");
        assertThat(strings).contains("1","2");
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        List<String> strings = Splitter.split("1,2:3");
        assertThat(strings).contains("1","2","3");
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    public void splitAndSum_custom_구분자() throws Exception {
        List<String> strings = Splitter.split("//;\n1;2;3");
        assertThat(strings).contains("1","2","3");
    }
}
