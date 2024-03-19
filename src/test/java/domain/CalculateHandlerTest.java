package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateHandlerTest {

    CalculateHandler calculateHandler;

    @BeforeEach
    void setUp() {
        calculateHandler = new CalculateHandler();
    }

    @Test
    @DisplayName("2개의 연산자가 포핟된 복잡한 연산")
    void complex1() {
        SeparationDto separationDto = new SeparationDto(List.of(2,2,2), List.of("+", "/"));
        int result = calculateHandler.handle(separationDto);
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("3개의 연산자가 포핟된 복잡한 연산")
    void complex2() {
        final String[] inputs = {"2", "+", "2", "-", "1", "*", "5"};
        int result = calculateHandler.handle(new SeparationDto(List.of(2, 2, 1, 5), List.of("+", "-", "*")));
        assertThat(result).isEqualTo(15);
    }
}
