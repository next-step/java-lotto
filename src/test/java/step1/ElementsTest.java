package step1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ElementsTest {
    @Test
    void 요소들을_리스트로_생성한다() {
        //Given
        List<Element> testElements = new ArrayList<>();
//        Elements elements = new Elements(testElements);
        Elements elements = Elements.from(testElements);

        //When
        //Then
        assertThat(elements).isNotNull();
    }
}