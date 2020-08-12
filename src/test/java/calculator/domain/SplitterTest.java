package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @DisplayName("Splitter 문자열 분리자 설정 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,3,1:true", "1|4|5:true", "//;\\n1;2;3:false"})
    void isDefaultSplitter_test(String input, boolean result) {
        Splitter splitter = Splitter.create(input);

        assertThat(splitter.isDefaultSplitter()).isEqualTo(result);
    }

    @DisplayName("Splitter 빈 문자열 입력 확인 테스트")
    @Test
    void isEmpty_test() {
        assertThat(Splitter.isEmpty(null)).isTrue();
        assertThat(Splitter.isEmpty("")).isTrue();
        assertThat(Splitter.isEmpty("fullText")).isFalse();
    }

}
