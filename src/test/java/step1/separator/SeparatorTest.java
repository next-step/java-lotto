package step1.separator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeparatorTest {

    @DisplayName("Separator 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        String inputValue = "//;\n1;2;3,4:5";

        // when
        Separator separator = new Separator(inputValue);

        // then
        assertThat(separator).isNotNull();
    }


    @DisplayName("Separator 인스턴스 커스텀 구분자를 기준으로 분리하고 반화 여부 테스트")
    @Test
    void 분리하기() {
        // given
        String[] expected = {"1", "2", "3"};
        String inputValue = "//;\n1;2;3";

        // when
        Separator separator = new Separator(inputValue);
        String[] actual = separator.splitByDelimiter();

        // then
        assertThat(actual).isEqualTo(expected);
    }

}