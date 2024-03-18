package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculateClientTest {

    @Test
    @DisplayName("null이나 빈 문자열이라면 예외")
    void null_or_empty(){
        assertThatThrownBy(() -> {
            CalculateClient.process(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            CalculateClient.process("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
