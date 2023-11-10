package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class OperationSymbolTest {

    @DisplayName("인자로 받은 연산 기호가 (+, -, *, /)중 일치하는 것이 있는 지 확인한다.")
    @ParameterizedTest
    @CsvSource({"+,true", "-,true", "*,true", "/,true", ":,false", "=,false"})
    void validateSymbol(String symbol, boolean expectedResult) {
        // when & then
        assertThat(OperationSymbol.isOperationSymbol(symbol)).isEqualTo(expectedResult);
    }
}