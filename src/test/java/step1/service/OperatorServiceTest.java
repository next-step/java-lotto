package step1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorServiceTest {

    @ParameterizedTest
    @DisplayName("사칙 연산을 모두 포함하는 연산")
    @CsvSource(value = {
            "2 + 3 * 4 / 2:10"
            , "2 + 3 * 4 / 2 * 2:20"
            , "2 + 5 * 6 / 2:21"
    }, delimiter = ':')
    void 사칙_연산_모두_포함하는_연산(String input, String result) {
        assertThat(new OperatorService().operate(input)).isEqualTo(Integer.parseInt(result));
    }
}