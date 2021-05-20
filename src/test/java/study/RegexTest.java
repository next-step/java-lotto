package study;

import static org.assertj.core.api.Assertions.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegexTest {

    String regex;
    Pattern compile;

    @BeforeEach
    public void beforeEach() {
        regex = "//(.)\n(.*)";
        compile = Pattern.compile(regex);
    }

    @Test
    @DisplayName("정규표현식_지정_외_그룹호출_예외_테스트")
    void regex_group_index_out_of_bounds_test() {
        Matcher matcher = compile.matcher("//;\n1;2;3");
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group(1)).isNotNull().isNotEmpty();
        assertThat(matcher.group(2)).isNotNull().isNotEmpty();
        assertThatThrownBy(() -> matcher.group(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("정규표현식_그룹호출_테스트")
    void regex_group_test() {
        Matcher matcher = compile.matcher("//;\n");
        assertThat(matcher.find()).isTrue();
        assertThat(matcher.group(1)).isNotNull().isNotEmpty().isEqualTo(";");
        assertThat(matcher.group(2)).isNotNull().isEmpty();

        Matcher matcher1 = compile.matcher("//;\n123");
        assertThat(matcher1.find()).isTrue();
        assertThat(matcher1.group(1)).isNotNull().isNotEmpty().isEqualTo(";");
        assertThat(matcher1.group(2)).isNotNull().isNotEmpty().isEqualTo("123");
    }

    @Test
    @DisplayName("정규표현식_포함되는_문자_테스트")
    void regex_test() {
        Matcher matcher1 = compile.matcher("//;\n");
        assertThat(matcher1.find()).isTrue();

        Matcher matcher2 = compile.matcher("//;\n123");
        assertThat(matcher2.find()).isTrue();
    }

    @Test
    @DisplayName("정규표현식_포함되지않은_문자_테스트")
    void not_regex_test() {
        Matcher matcher = compile.matcher("");
        assertThat(matcher.find()).isFalse();

        Matcher matcher1 = compile.matcher("//;;\n");
        assertThat(matcher1.find()).isFalse();
        assertThatThrownBy(() -> matcher1.group(1))
                .isInstanceOf(IllegalStateException.class);
    }
}
