package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @DisplayName("1등 로또와 매칭하는 결과를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:6", "1, 2, 3, 4, 5, 7:5", "1, 2, 3, 4, 7, 8:4", "1, 2, 3, 7, 8, 9:3"
            , "1, 2, 7, 8, 9, 10:2", "1, 7, 8, 9, 10, 11:1", "7, 8, 9, 10, 11, 12:0"}, delimiter = ':')
    void winning_lotto(final String autoLotto, final int countOfMatch) {

        final WinningLottoNumber winningLottoNumber = WinningLottoNumber.from("1, 2, 3, 4, 5, 6");
        final LottoNumber lottoNumber = LottoNumber.from(autoLotto);
        final LottoNumbers lottoNumbers = new LottoNumbers(List.of(lottoNumber));

        assertThat(lottoNumbers.match(winningLottoNumber)).contains(countOfMatch);
    }
}
