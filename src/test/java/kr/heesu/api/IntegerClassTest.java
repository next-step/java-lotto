package kr.heesu.api;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntegerClassTest {

    @Test
    void parseIntTest() {
        String input = "a";
        assertThatThrownBy(() -> Integer.parseInt(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
