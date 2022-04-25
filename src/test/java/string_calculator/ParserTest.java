package string_calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    @Test
    void parseTest() {
        Parser p = new Parser();
        p.parse("1 + 2");
        List<Value> values = new ArrayList<Value>() {{
            add(new Integer(1));
            add(Operator.PLUS);
            add(new Integer(2));
        }};
        assertThat(p.values).isEqualTo(values);
    }

    @Test
    void shouldThrowError() {
        Parser p = new Parser();
        assertThatThrownBy(() -> p.parse("1+2")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> p.parse("1 + 2 +")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> p.parse("1 + 2 ! 3")).isInstanceOf(IllegalArgumentException.class);
    }
}
