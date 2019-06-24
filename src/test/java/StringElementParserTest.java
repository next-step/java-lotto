import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
