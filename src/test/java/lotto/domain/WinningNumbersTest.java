package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.constant.LottoRank;
import lotto.utils.LottoNumbersUtil;

/**
 * WinningNumbers 생성 및 기능 테스트
 */
public class WinningNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {1,6})
    @DisplayName("당청번호와 보너스 번호 중복 시 예외처리")
    void invalidate(int bonusNumber) {
        // given
        LottoNumbers lottoNumbers = LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6");

        // then
        assertThatThrownBy(() -> new WinningNumbers(lottoNumbers, new LottoNumber(bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7:FIRST", "1,2,3,4,5,7:6:SECOND", "1,2,3,4,5,7:8:THIRD", "1,2,3,7,8,9:10:FIFTH",
            "1,2,10,11,12,13:20:OUT_OF_RANK"}, delimiter = ':')
    @DisplayName("로또와 당첨번호, 보너스번호 비교하여 순위 확인")
    void getRank(String textLottoNumber, int bonusNumber, LottoRank rank) {
        // given
        LottoNumbers lottoNumbers = LottoNumbersUtil.toLottoNumbers(textLottoNumber);
        WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers, new LottoNumber(bonusNumber));

        // then
        assertThat(winningNumbers.findRank(LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6"))).isEqualTo(rank);
    }
}
