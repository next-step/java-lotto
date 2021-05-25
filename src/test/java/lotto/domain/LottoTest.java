package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.utils.LottoNumbersUtil;

/**
 * Lotto 객체 생성 및 기능 검증 테스트
 */
class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,7,8:4", "1,2,3,7,8,9:3"}, delimiter = ':')
    void get_matchingNumber_count(String textWinningNumber, int matchingCount) {
        // given
        LottoNumbers lottoNumbers = LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6");
        LottoNumbers winningNumbers = LottoNumbersUtil.toLottoNumbers(textWinningNumber);

        // when
        Lotto lotto = new Lotto(lottoNumbers);

        //then
        assertThat(lotto.getCountOfMatchingNumber(winningNumbers)).isEqualTo(matchingCount);
    }

    @Test
    @DisplayName("6개의 로또번호를 가진 로또 생성")
    void create_lotto() {
        // given
        LottoNumbers lottoNumbers = LottoNumbersUtil.toLottoNumbers("1,2,3,4,5,6");

        // when
        Lotto lotto = new Lotto(lottoNumbers);

        //then
        assertThat(lotto.getLottoNumbers()).isNotNull();
    }
}
