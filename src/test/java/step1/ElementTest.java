package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ElementTest {
    @Test
    void 쪼개진_입력문자열의_요소를_생성한다() {
        //Given
        Element element = new Element();
        //When
        //Then
        assertThat(element).isNotNull();
    }

    @Test
    void 쪼개진_입력문자열의_요소는_값을_가진다() {
        //Given
        int testValue = 1;
        Element element = new Element(testValue);
        //When
        //Then
        assertThat(element.value).isEqualTo(1);
    }
}
