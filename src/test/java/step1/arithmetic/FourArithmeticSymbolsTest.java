package step1.arithmetic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class FourArithmeticSymbolsTest {

    @Test
    @DisplayName("symbol 을 이용해 필요한 이넘타입을 찾는지 확인")
    void findBy() {
        assertAll(
                () -> assertThat(FourArithmeticSymbols.findBy("+"))
                        .isEqualTo(FourArithmeticSymbols.PLUS),
                () -> assertThat(FourArithmeticSymbols.findBy("-"))
                        .isEqualTo(FourArithmeticSymbols.MINUS),
                () -> assertThat(FourArithmeticSymbols.findBy("*"))
                        .isEqualTo(FourArithmeticSymbols.MULTIPLICATION),
                () -> assertThat(FourArithmeticSymbols.findBy("/"))
                        .isEqualTo(FourArithmeticSymbols.DIVISION)
        );
    }
}
