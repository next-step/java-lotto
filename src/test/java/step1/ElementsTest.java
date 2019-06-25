package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ElementsTest {

    private static final String COMMA = ",";

    @Test
    void 요소들의_합을_구한다() {
        //Given
        String testElementsFromInputString = "1,2,3,4,5";
        String[] testElements = testElementsFromInputString.split(COMMA);

        //When
        Elements elements = Elements.from(testElements);
        Element result = elements.sum();

        //Then
        assertThat(result.getValue()).isEqualTo(15);
    }
}