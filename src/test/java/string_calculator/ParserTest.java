package string_calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    @Test
    void parseTest() {
        Parser parser = new Parser();
        parser.parse("1 + 2");
        List<Object> values = new ArrayList<Object>() {{
            add(1);
            add(Operator.PLUS);
            add(2);
        }};
        assertThat(parser.values).isEqualTo(values);
    }

    @Test
    void shouldThrowError() {
        Parser parser = new Parser();
        assertThatThrownBy(() -> parser.parse("1+2")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> parser.parse("1 + 2 +")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> parser.parse("1 + 2 ! 3")).isInstanceOf(IllegalArgumentException.class);
    }
}
