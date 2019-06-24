import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.ArrayList;
import java.util.List;

public class StringElementParserTest {

    @DisplayName("요소는 한개가 검출되어야 한다.")
    @Test
    public void testOneElement() {
        List<String> elements = new ArrayList<>();

        StringElementParser stringElementParser = new StringElementParser("1");
        stringElementParser.parseElement(elements::add);

        Assertions.assertThat(elements).hasSize(1);
        Assertions.assertThat(elements).containsOnly("1");
    }

    @DisplayName("요소는 세개가 검출되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings={"1:2,3", "1,2,3", "1:2,3"})
    public void testThreeElement(String string) {
        List<String> elements = new ArrayList<>();

        StringElementParser stringElementParser = new StringElementParser(string);
        stringElementParser.parseElement(elements::add);

        Assertions.assertThat(elements).hasSize(3);
        Assertions.assertThat(elements).containsOnly("1", "2", "3");
    }
}
