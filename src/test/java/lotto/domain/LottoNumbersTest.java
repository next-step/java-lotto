package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("1등 로또와 매칭하는 결과를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 2, 3, 4, 5, 6:6:false"
            , "1, 2, 3, 4, 5, 45:5:true"
            , "1, 2, 3, 4, 5, 7:5:false"
            , "1, 2, 3, 4, 7, 8:4:false"
            , "1, 2, 3, 7, 8, 9:3:false"
            , "1, 2, 7, 8, 9, 10:2:false"
            , "1, 7, 8, 9, 10, 11:1:false"
            , "7, 8, 9, 10, 11, 12:0:false"}, delimiter = ':')
    void winning_lotto(final String autoLotto, final int countOfMatch, final boolean bonusOfMatch) {

        final WinningLottoNumber winningLottoNumber = WinningLottoNumber.from("1, 2, 3, 4, 5, 6", "45");
        final LottoNumber lottoNumber = LottoNumber.from(autoLotto);
        final LottoNumbers lottoNumbers = new LottoNumbers(List.of(lottoNumber));

        assertThat(lottoNumbers.match(winningLottoNumber)).contains(WinningPrize.from(countOfMatch, bonusOfMatch));
    }

    @DisplayName("로또 번호는 5개만 입력 또는 7개 이상 입력하거나 중복된 숫자를 입력하면 익셉션 처리한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 2, 4, 5, 6", "1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
    void error_create_lotto2(final String input) {

        assertThatThrownBy(() -> LottoNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("6개의 숫자를 입력해야 하며 중복 숫자는 입력할 수 없습니다.");
    }
}
