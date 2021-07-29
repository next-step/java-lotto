package lotto.domain;

import lotto.domain.dto.LottoResult;
import lotto.exception.IllegalBonusNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningLottoTest {

    @DisplayName("당첨 번호에 포함된 수는 보너스 볼로 선택할 수 없다.")
    @Test
    void bonus_number_validation() {
        assertThatThrownBy(() -> WinningLotto.of(LottoNumbers.of("1,2,3,4,5,6"), LottoNumber.of("1")))
                .isInstanceOf(IllegalBonusNumberException.class);
    }

    @DisplayName("로또 번호를 입력 받아 보너스 번호 일치 여부와 일치한 카운트를 계산한 결과를 리턴한다.")
    @Test
    void lotto_numbers_to_result() {
        WinningLotto bonus = WinningLotto.of(LottoNumbers.of("1,2,3,4,5,6"), LottoNumber.of("7"));
        LottoResult lottoResult = bonus.toResult(LottoNumbers.of("1,2,3,4,5,7"));

        assertThat(lottoResult.getCount()).isEqualTo(5);
        assertThat(lottoResult.isMatchBonus()).isTrue();
    }
}