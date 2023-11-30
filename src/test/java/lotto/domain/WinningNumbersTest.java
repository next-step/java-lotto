package lotto.domain;

import lotto.enums.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.utils.StringParser.stringToIntegerList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {
    @Test
    void test_보너스넘버생성() {
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(List.of(1, 3, 8, 39, 44, 33)), LottoNumber.Of(7));
        assertThat(winningNumbers.bonusNumber()).isEqualTo(LottoNumber.Of(7));
    }

    @Test
    void exceptionTest_보너스넘버중복() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(new LottoNumbers(List.of(2, 3, 4, 5, 6, 7)), LottoNumber.Of(7)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 80", "1, 4, 6, 2, 15, 19, 43, 25, 7"})
    void exceptionTest_갯수오류(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningNumbers(new LottoNumbers(stringToIntegerList(input)), LottoNumber.Of(7)));
    }

    @Test
    void test_랭크구하기() {
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)), LottoNumber.Of(45));
        LottoNumbers target = new LottoNumbers(stringToIntegerList("6, 5, 4, 3, 45, 1"));

        assertThat(winningNumbers.findRank(target).get()).isEqualTo(Rank.SECOND_PLACE);
    }
}