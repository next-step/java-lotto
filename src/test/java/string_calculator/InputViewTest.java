package string_calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    void parseTest() {
        InputView i = new InputView();
        i.parse("1 + 2");
        List<Value> values = new ArrayList<Value>() {{
            add(new Integer(1));
            add(new Operator("+"));
            add(new Integer(2));
        }};
        assertThat(i.values).isEqualTo(values);
    }
}
