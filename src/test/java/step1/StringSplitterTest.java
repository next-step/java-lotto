package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @Test
    void 입력된_문자열을_규칙에_따라_분할하여_배열로_반환한다() {
        //Given
        String inputString = "1,2,3";
        String[] expectedResult = new String[]{"1", "2", "3"};

        //When
        String[] splitResult = StringSplitter.splitToArray(inputString);

        //Then
        assertThat(splitResult).isEqualTo(expectedResult);
    }

    @Test
    void 문자열_배열을_Elements로_변환하여_반환한다() {
        //Given
        String inputString = "1,2,3";
        String[] inputArray = new String[]{"1", "2", "3"};
        Elements expectedResult = Elements.from(inputArray);

        //When
        Elements splitResult = StringSplitter.splitToElements(inputString);

        //Then
        assertThat(splitResult.sum().getValue()).isEqualTo(expectedResult.sum().getValue());
    }
}
