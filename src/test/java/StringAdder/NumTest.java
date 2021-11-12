package StringAdder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumTest {
    private final int VALUE_ONE = 1;
    private final int VALUE_TWO = 2;
    private final int VALUE_ADDED = 3;

    @Test
    void testAdd() {
        Num one = new Num(VALUE_ONE);
        Num two = new Num(VALUE_TWO);

        assertThat(one.add(two)).isEqualTo(new Num(VALUE_ADDED));
    }
}
