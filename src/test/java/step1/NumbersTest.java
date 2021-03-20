package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumbersTest {
    private static List<Number> originalList;

    @BeforeEach
    void setUp() {
        originalList = Arrays.asList(
                new Number("1"),
                new Number("2"),
                new Number("3"));
    }

    @Test
    @DisplayName("Numbers 객체 생성 테스트")
    void ofTest() {
        Numbers original = new Numbers(originalList);

        Numbers numbers = Numbers.of("1,2,3");

        assertThat(original).isEqualTo(numbers);
    }

    @Test
    @DisplayName(":으로 구분해서 Numbers객체 만들기")
    void commaSplitNumbers() {
        List<Number> numberList = Numbers.exportSplitNumbers("1,2,3");

        assertThat(numberList).isEqualTo(originalList);
    }

    @Test
    @DisplayName(",로 구분해서 Numbers객체 만들기")
    void colonSplitNumbers() {
        List<Number> numberList = Numbers.exportSplitNumbers("1:2:3");

        assertThat(numberList).isEqualTo(originalList);
    }

    @Test
    @DisplayName(",로 구분해서 Numbers객체 만들기")
    void colonAndCommaSplitNumbers() {
        List<Number> numberList = Numbers.exportSplitNumbers("1,2:3");

        assertThat(numberList).isEqualTo(originalList);
    }

    @Test
    @DisplayName("커스텀 구분자로 Number객체 만들기")
    void exportCustomDelimiterNumbers() {
        List<Number> customNumberList = Numbers.exportCustomDelimiterNumbers("//&\n1&2&3");

        assertThat(customNumberList).isEqualTo(originalList);
    }

    @Test
    @DisplayName("문자열 더하기 테스트")
    void sum() {
        Numbers a = new Numbers(originalList);

        assertThat(a.sum()).isEqualTo(6);
    }
}
