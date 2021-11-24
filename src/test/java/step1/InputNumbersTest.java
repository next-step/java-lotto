package step1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputNumbersTest {
    @Test
    void create() {
        List<InputNumber> inputNumbers = new ArrayList() {{
            add(new InputNumber(1));
            add(new InputNumber(2));
        }};
        assertThat(new InputNumbers(inputNumbers)).isEqualTo(new InputNumbers(inputNumbers));
    }

    @Test
    void getList() {
        InputNumbers inputNumbers = new InputNumbers(new ArrayList() {{
            add(new InputNumber(1));
            add(new InputNumber(2));
        }});
        assertThat(inputNumbers.getList()).containsExactly(new InputNumber(1), new InputNumber(2));
    }

    @Test
    void sum() {
        InputNumbers inputNumbers = new InputNumbers(new ArrayList() {{
            add(new InputNumber(1));
            add(new InputNumber(2));
        }});
        assertThat(inputNumbers.sum()).isEqualTo(new InputNumber(3));
    }
}
