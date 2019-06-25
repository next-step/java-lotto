import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class StringElementParserTest {
    private List<String> elements;

    @BeforeEach
    public void setUp() {
        elements = new ArrayList<>();
    }

    @DisplayName("요소는 한개가 검출되어야 한다.")
    @Test
    public void testOneElement() {
        StringElementParser stringElementParser = new StringElementParser("1");
        stringElementParser.parseElement(elements::add);

        assertElement("1");
    }

    @DisplayName("요소는 세개가 검출되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings={"1:2,3", "1,2,3", "1:2,3"})
    public void testThreeElement(String string) {
        StringElementParser stringElementParser = new StringElementParser(string);
        stringElementParser.parseElement(elements::add);

        assertElement("1", "2", "3");
    }

    @DisplayName("커스텀 패턴으로 요소가 2개 검출 되어야 한다.")
    @Test
    public void testTowElement() {
        StringElementParser stringElementParser = new StringElementParser("//;\n1;2");
        stringElementParser.parseElement(elements::add);

        assertElement("1", "2");
    }

    private void assertElement(String ...elements) {
        Assertions.assertThat(this.elements).hasSize(elements.length);
        Assertions.assertThat(this.elements).containsOnly(elements);
    }
}
