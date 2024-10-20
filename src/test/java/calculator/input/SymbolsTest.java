package calculator.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SymbolsTest {

    @Test
    void 정상적으로_기호추출() {
        String str = "1 + 2 / 3";
        String[] strs = str.split(" ");

        Symbols symbols = new Symbols();
        symbols.generateSymbols(strs);

        assertThat(symbols.getSymbols()).hasSize(2);
    }

    @Test
    void 정상적인_숫자_추출이_아닌경우() {
        String str = "1 / 2 _ 0";
        String[] strs = str.split(" ");

        Symbols symbols = new Symbols();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            symbols.generateSymbols(strs);
        }).withMessage("연산 가능한 기호가 아닙니다.");

        String str2 = "1  a s2";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            symbols.generateSymbols(strs);
        }).withMessage("연산 가능한 기호가 아닙니다.");

    }

}
