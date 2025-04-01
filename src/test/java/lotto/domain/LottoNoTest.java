package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoNoTest {
    @Test
    void createTest() {
        assertThat(new LottoNo("3")).isEqualTo(new LottoNo(3));
    }

    @DisplayName("유효하지 않은 로또 번호는 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "46"})
    void invalidNumberTest(int argument) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNo(argument))
                .withMessage("invalid Lotto number : " + argument);
    }

}
