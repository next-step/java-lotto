package Lotto.Number;

import Lotto.Helper.Helper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("로또 숫자 리스트는")
public class LottoNumbersTest {

    @DisplayName("길이가 6이 아닐 경우 에러 발생")
    @Test
    void lottoNumbersAboveOrUnder6ThrowsError() {
        List<LottoNumber> given = Stream.of(1, 2, 3, 4, 5).map(LottoNumber::new).collect(Collectors.toList());
        assertThatThrownBy(() -> new LottoNumbers(given)).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("로또 숫자는 6개입니다.");
    }

    @DisplayName("길이가 6일 경우 정상")
    @Test
    void lottoNumbersLengthMustBe6() {
        List<LottoNumber> given = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        assertDoesNotThrow(() -> new LottoNumbers(given));
    }

    @DisplayName("당첨숫자를 몇 개 포함하는지 알려준다.")
    @ParameterizedTest(name = "{1}개 포함")
    @CsvSource(value = {"0:6", "1:5", "2:4", "3:3", "4:0"}, delimiter = ':')
    void tellsHowManyWinningNumbersAreIncluded(int ticketIndex, int winningNumberCounts) {
        LottoNumbers given = Helper.lottoNumbers(ticketIndex);
        int result = given.countWinningNumbers(Helper.winningNumbers());
        assertThat(result).isEqualTo(winningNumberCounts);
    }
}
