package step1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {
    @Test
    public void checkDefaultValidator_Throws() {
        assertThatThrownBy(() -> new Expression(Arrays.asList(0, 1, 2, 3, 4, 5, -1, Integer.MIN_VALUE)))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void of() {
        assertThat(Expression.of("3,5:2,3:4,0,2").stream())
                .containsExactly(3, 5, 2, 3, 4, 0, 2);
    }

    @Test
    public void of_CustomDelimiter() {
        assertThat(Expression.of("3@5@2@3@4@0@2", "@").stream())
                .containsExactly(3, 5, 2, 3, 4, 0, 2);
    }
}
