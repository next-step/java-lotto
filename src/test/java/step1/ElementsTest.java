package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ElementsTest {

    public static final String COMMA = ",";

    @Test
    void 요소들을_리스트로_생성한다() {
        //Given
        String testElementsFromInputString = "1,2,3,4,5";
        String[] testElements = testElementsFromInputString.split(COMMA);

        //When
        Elements elements = Elements.from(testElements);

        //Then
        assertThat(elements).isNotNull();
    }
}