package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.utils.StringParser.stringToIntegerList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {
    @Test
    void test_수동생성() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 3, 7, 39, 44, 33), 7);
        assertThat(winningNumbers.numbers()).hasSize(6);
        assertThat(winningNumbers.bonusNumber()).isEqualTo(new LottoNumber(7));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 80", "1, 4, 6, 2, 15, 19, 43, 25, 7"})
    void exceptionTest_갯수오류(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(stringToIntegerList(input), 7));
    }

    @Test
    void test_번호일치여부() {
        WinningNumbers lottoNumbers = new WinningNumbers(stringToIntegerList("1, 2, 3, 4, 5, 6"), 7);
        LottoNumbers target = new LottoNumbers(stringToIntegerList("6, 5, 4, 3, 45, 1"));

        assertThat(lottoNumbers.matchNumbers(target)).isEqualTo(5);
    }

    @Test
    void test_보너스넘버포함여부() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumber = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(winningNumber.containBonusNumber(lottoNumbers)).isTrue();
    }
}