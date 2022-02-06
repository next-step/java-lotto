package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    private static Stream<Arguments> 구분자를_기준으로_숫자를_나눈다() {
        return Stream.of(
            Arguments.of(Arrays.asList(1,2,3)),
            Arguments.of(Arrays.asList(123,342,330209)),
            Arguments.of(Arrays.asList(0,1,2,3,4,5,6,7,8,9))
        );
    }

    @ParameterizedTest
    @MethodSource
    void 구분자를_기준으로_숫자를_나눈다(List<Integer> numbers) {
        String text = "";
        for(int i = 0; i < numbers.size(); i++) {
            if(i == numbers.size()-1) {
                text += numbers.get(i);
                continue;
            }
            switch (i % 3) {
                case 0:
                    text += numbers.get(i) + ",";
                    break;
                case 1:
                    text += numbers.get(i) + ":";
                    break;
                case 2:
                    text += numbers.get(i) + "-";
                    break;
            }
        }
        final List<String> delimiters = Arrays.asList(",",":", "-");
        final Parser parser = new Parser(text, delimiters);
        assertThat(parser.splitNumbersByDelimiter()).isEqualTo(numbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:3:3:", "1::3", ":1:32:2","1ab:3","1:2:","1:2a3a"})
    void 숫자_이외의_값이_들어가는_경우(String text) {
        final List<String> delimiters = Arrays.asList(",",":", "a");
        final Parser parser = new Parser(text, delimiters);
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> parser.splitNumbersByDelimiter())
            .withMessage("[ERROR] 숫자 이외의 값을 계산할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,3a-2", "22,-23a3123:1"})
    void 음수가_들어가는_경우(String text) {
        final List<String> delimiters = Arrays.asList(",",":", "a");
        final Parser parser = new Parser(text, delimiters);
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> parser.splitNumbersByDelimiter())
            .withMessage("[ERROR] 음수 값은 입력할 수 없습니다.");
    }
}
