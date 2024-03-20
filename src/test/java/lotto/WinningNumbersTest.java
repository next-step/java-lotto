package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class WinningNumbersTest {
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {
            "",
            " ",
            "1 2 3 4 5 6",
            "11, 22, 33, 44, 55, 66",
            "1, 2, 3, 4, 5",
            "가, 나, 다, 라, 마, 바"})
    void 적절하지_않은_당첨숫자_생성(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningNumbers(input, ", "));
    }

    @Test
    void 숫자를_포함하는지() {
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6", ", ");
        assertThat(winningNumbers.contains(new LottoNumber(3))).isTrue();
    }

}
