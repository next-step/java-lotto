package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FormulaTest {
    @Test
    void 생성_테스트() {
        Elements elements = Elements.of("1 + 2");
        assertThat(new Formula("1 + 2")).isEqualTo(new Formula(elements));
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3", "1:1", "2 * 4 + 5:13"}, delimiter = ':')
    void 계산_테스트(String formula, int result) {
        Formula f = new Formula(formula);

        assertThat(f.calculate()).isEqualTo(result);
    }
}
