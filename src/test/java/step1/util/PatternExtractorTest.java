package step1.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternExtractorTest {


    @Test
    @DisplayName("입력 정규표현식의 패턴에 해당하는 문자열을 추출한다.")
    void extract() {
        String input = "2 + 3 * 4 / 2";
        String result = PatternExtractor.extract(input,"\\d+");
        assertThat(result).isEqualTo("2");
    }

    @Test
    @DisplayName("입력 정규표현식의 패턴에 해당하는 문자열을 모두 리스트 형태로 추출한다.")
    void extractAll() {
        String input = "2 + 3 * 4 / 2";
        List<String> result = PatternExtractor.extractAll(input,"\\d+");
        assertThat(result).containsExactly("2", "3", "4", "2");
    }

    @Test
    @DisplayName("입력 정규표현식에 해당하는 문자가 하나라도 존재하는 경우 true를 반환한다.")
    void isMatch() {
        String input = "2 + 3 * 4 / 2";
        boolean result = PatternExtractor.isMatch(input,"\\d+");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("입력 정규표현식의 패턴에 해당하는 문자열을 Stack<Integer>에 담아 반환한다.")
    void numbers() {
        String input = "2 + 3 * 4 / 2";
        Stack<Integer> result = PatternExtractor.stack(input,"\\d+");
        assertThat(result.pop()).isEqualTo(2);
        assertThat(result.pop()).isEqualTo(4);
        assertThat(result.pop()).isEqualTo(3);
        assertThat(result.pop()).isEqualTo(2);
    }

}
