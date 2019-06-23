package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSplitterTest {

    @Test
    void 입력된_문자열을_규칙에_따라_분할한다() {
        //Given
        String inputString = "1,2,3";
        String[] expectedResult = new String[]{"1", "2", "3"};

        //When
        String[] splitResult = StringSplitter.splitString(inputString);

        //Then
        assertThat(splitResult).isEqualTo(expectedResult);
    }
}
