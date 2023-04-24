package calculator.domain.constant;

import static calculator.domain.constant.OperatorsConstant.isProperSymbol;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorsConstantTest {

    @ParameterizedTest(name = "올바른 사칙연산 기호가 유입 되었을 경우 true 를 반환한다.")
    @ValueSource(strings = {"+","-","*","/"})
    void properSymbolsTest(String source) {
        assertThat(isProperSymbol(source)).isTrue();
    }

    @ParameterizedTest(name = "올바른 사칙연산 기호가 유입 되었을 경우 false 를 반환한다.")
    @ValueSource(strings = {"(",">"})
    void invalidSymbolsTest(String source) {
        assertThat(isProperSymbol(source)).isFalse();
    }
}