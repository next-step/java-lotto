package LottoTest;

import lotto.domain.LottoGame;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class WinningNumberTest {
    @ParameterizedTest
    @CsvSource(value = {"6", "0", "46"}, delimiter = ':')
    @DisplayName("잘못된 보너스 번호면 Exception")
    void Given_InvalidBonusNumber_When_New_Then_Exception() {
        int duplicatedBonusNumber = 6;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy((() -> new WinningNumber(new LottoGame(Arrays.asList(1, 2, 3, 4, 5, 6)), duplicatedBonusNumber)));
    }
}
