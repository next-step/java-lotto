package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTokensTest {

    @Test
    public void create() {
        assertThat(new NumberTokens("").getTokens()).isEqualTo(new NumberTokens("0").getTokens());
    }

    @Test
    public void create_null() {
        assertThat(new NumberTokens("").getTokens()).isEqualTo(new NumberTokens("0").getTokens());
    }

    @Test
    public void create_negative() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("-1");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
