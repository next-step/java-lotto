package step1;

import org.junit.jupiter.api.Test;
import step1.domain.Number;
import step1.domain.Numbers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumbersTest {
    @Test
    void create() {
        List<Number> numbers = new ArrayList() {{
            add(new Number(1));
            add(new Number(2));
        }};
        assertThat(new Numbers(numbers)).isEqualTo(new Numbers(numbers));
    }

    @Test
    void getList() {
        Numbers numbers = new Numbers(new ArrayList() {{
            add(new Number(1));
            add(new Number(2));
        }});
        assertThat(numbers.getList()).containsExactly(new Number(1), new Number(2));
    }

    @Test
    void sum() {
        Numbers numbers = new Numbers(new ArrayList() {{
            add(new Number(1));
            add(new Number(2));
        }});
        assertThat(numbers.sum()).isEqualTo(new Number(3));
    }
}
