package step1.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternExtractorTest {

    private final String COMMON_INPUT = "2 + 3 * 4 / 2";

    @Test
    @DisplayName("입력 정규표현식의 패턴에 해당하는 문자열을 추출한다.")
    void extract() {
        String result = PatternExtractor.extract(COMMON_INPUT,"\\d+");
        assertThat(result).isEqualTo("2");
    }

    @Test
    @DisplayName("입력 정규표현식의 패턴에 해당하는 문자열을 모두 리스트 형태로 추출한다.")
    void extractAll() {
        List<String> result = PatternExtractor.extractAllToList(COMMON_INPUT,"\\d+");
        assertThat(result).containsExactly("2", "3", "4", "2");
    }

    @Test
    @DisplayName("입력 정규표현식에 해당하는 문자가 하나라도 존재하는 경우 true 를 반환한다.")
    void isMatch() {
        boolean result = PatternExtractor.isMatch(COMMON_INPUT,"\\d+");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("입력 정규표현식의 패턴에 해당하는 문자열을 LinkedList<Integer>에 담아 반환한다.")
    void numbers() {
        LinkedList<Integer> result = PatternExtractor.extractAllToLinkedList(COMMON_INPUT,"\\d+");
        assertThat(result.pop()).isEqualTo(2);
        assertThat(result.pop()).isEqualTo(3);
        assertThat(result.pop()).isEqualTo(4);
        assertThat(result.pop()).isEqualTo(2);
    }

}
