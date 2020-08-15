package calculator;

import calculator.model.seperator.BasicSeparator;
import calculator.model.seperator.CustomSeparator;
import calculator.model.seperator.Separator;
import calculator.model.SeparatorFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SeparatorTest {

    @Test
    @DisplayName("기본 Separator 생성하기")
    void createBasicSeparator() {
        Separator separator = SeparatorFactory.create("1,2:3");

        assertThat(separator).isEqualTo(BasicSeparator.of());

    }

    @Test
    @DisplayName("커스텀 Separator 생성하기")
    void createCustomSeparator() {
        Separator separator = SeparatorFactory.create("//;\n1;2;3");

        assertThat(separator).isEqualTo(new CustomSeparator(";"));

    }

    @Test
    @DisplayName("기본 구분자로 문자열 자르기")
    void splitByDelimiter() {
        Separator separator = BasicSeparator.of();

        List<String> result = separator.splitByDelimiter("1,2:3");

        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열 자르기")
    void splitByCustomDelimiter() {
        Separator separator = new CustomSeparator("&");

        List<String> result = separator.splitByDelimiter("1&2&3");

        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

}
