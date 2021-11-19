package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void number() {
        Number stringInput = new Number("1");
        Number integerInput = new Number(1);

        assertThat(stringInput).isEqualTo(integerInput);
        assertEquals(stringInput.hashCode(), integerInput.hashCode());
    }

    @Test
    void runtimeExceptionBecauseNumberIsLessThan0() {
        assertThatThrownBy(() -> new Number("-1"))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    void add() {
        Number first = new Number(1);
        Number second = new Number(2);

        assertEquals(new Number(3), first.add(second));
    }
}
