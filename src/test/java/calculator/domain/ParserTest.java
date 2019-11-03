package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Parser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {

    @Test
    @DisplayName("쉼표와 콜론으로 문자열 파싱한다.")
    void parsingStrings() {

        List<Integer> numbers = Parser.convertToInteger("1,2:3");

        assertThat(numbers).hasSize(3);
        assertThat(numbers).containsExactly(1, 2, 3);

    }

    @Test
    @DisplayName("사용자정의 구분자를 받아 파싱한다.")
    void parsingStringWithCustomDelimit() {

        List<Integer> numbers = Parser.convertToInteger("//;\\n1;2;3");

        assertThat(numbers).hasSize(3);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("기본구분자, 커스텀 구분자 외에 다른 문자 입력 시 에러를 반환한다.")
    void anotherStringThrowException() {

        assertThatThrownBy(() -> {
            Parser.convertToInteger("1:2#3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("기본구분자, 커스텀 구분자 외에 다른 문자를 입력할 수 없습니다.");

    }

    @Test
    @DisplayName("음수 입력 시 에러를 반환한다.")
    void negativeThrowException() {

        assertThatThrownBy(() -> {
            Parser.convertToInteger("1:-2,3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("기본구분자, 커스텀 구분자 외에 다른 문자를 입력할 수 없습니다.");

    }

    @Test
    @DisplayName("커스텀구분자 문자가 //구분자\\n 형식이 아니면 에러를 반환한다..")
    void wrongCustomDelimiterThrowException() {

        assertThatThrownBy(() -> {
            Parser.convertToInteger("//:nn1:2:3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("커스텀구분자 정의는 //커스텀구분자\n 형식으로 입력해주세요.");

    }

    @Test
    @DisplayName("null 이면 0 반환한다.")
    void ifNullReturnZero() {

        List<Integer> numbers = Parser.convertToInteger(null);

        assertThat(numbers).hasSize(1);
        assertThat(numbers).containsExactly(0);
    }

    @Test
    @DisplayName("빈 문자열이면 0 반환한다.")
    void ifEmptyStringReturnZero() {

        List<Integer> numbers = Parser.convertToInteger("");

        assertThat(numbers).hasSize(1);
        assertThat(numbers).containsExactly(0);
    }
}
