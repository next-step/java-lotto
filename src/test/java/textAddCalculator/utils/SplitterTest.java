package textAddCalculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class SplitterTest {
    private Splitter splitter = new Splitter();

    @Test
    @DisplayName("기본 구분자를 이용한 콤마 split 테스트")
    void commaSplitTest() {
        String[] numArr = splitter.split("1,2,3,4");
        assertAll("split",
                () -> assertThat(numArr[0]).isEqualTo("1"),
                () -> assertThat(numArr[1]).isEqualTo("2"),
                () -> assertThat(numArr[2]).isEqualTo("3"),
                () -> assertThat(numArr[3]).isEqualTo("4"));
    }

    @Test
    @DisplayName("기본 구분자를 이용한 콜론 split 테스트")
    void colonSplitTest() {
        String[] numArr = splitter.split("1:2:3:4");
        assertAll("split",
                () -> assertThat(numArr[0]).isEqualTo("1"),
                () -> assertThat(numArr[1]).isEqualTo("2"),
                () -> assertThat(numArr[2]).isEqualTo("3"),
                () -> assertThat(numArr[3]).isEqualTo("4"));
    }

    @Test
    @DisplayName("기본 구분자를 이용한 통합 split 테스트")
    void allSplitTest() {
        String[] numArr = splitter.split("1,2:3,4");
        assertAll("split",
                () -> assertThat(numArr[0]).isEqualTo("1"),
                () -> assertThat(numArr[1]).isEqualTo("2"),
                () -> assertThat(numArr[2]).isEqualTo("3"),
                () -> assertThat(numArr[3]).isEqualTo("4"));
    }

    @Test
    @DisplayName("커스텀구분자 분리 테스트")
    void customDelimiterFindTest() {
        String inputString = "//;\n1;2;3;4";
        String[] numArr = splitter.split(inputString);
        assertAll("split",
                () -> assertThat(numArr[0]).isEqualTo("1"),
                () -> assertThat(numArr[1]).isEqualTo("2"),
                () -> assertThat(numArr[2]).isEqualTo("3"),
                () -> assertThat(numArr[3]).isEqualTo("4"));
    }

}
