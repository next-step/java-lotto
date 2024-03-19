package lotto.domain;

import lotto.data.LottoNumberVO;
import lotto.dto.LottoResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchasedLottoTest {

    @DisplayName("구매한 돈 만큼의 로또를 구매한다(1000원 단위).")
    @Test
    void buyLottoByMoney() {
        // given
        int purchasedPrice = 18000;
        PurchasedLotto purchasedLotto = new PurchasedLotto(purchasedPrice);

        // when
        int lottoSize = purchasedLotto.purchasedCount();

        // then
        assertThat(lottoSize).isEqualTo(18);
    }

    @DisplayName("로또 당첨 결과를 확인한다.")
    @Test
    void matchWinningLottoNumbers() {
        // given
        int purchasedPrice = 5000;
        List<LottoNumbers> manualLottoNumbers = List.of(
                new LottoNumbers(List.of(1, 2, 3, 10, 11, 12)),
                new LottoNumbers(List.of(1, 2, 3, 10, 11, 12)),
                new LottoNumbers(List.of(1, 2, 3, 4, 11, 12)),
                new LottoNumbers(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(List.of(1, 2, 3, 4, 5, 35))

        );
        PurchasedLotto purchasedLotto = new PurchasedLotto(purchasedPrice, manualLottoNumbers);

        LottoNumbers winningNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumberVO bonusNumber = new LottoNumberVO(35);

        // when
        LottoResultDto lottoResultDto = purchasedLotto.matchWinningNumbers(winningNumbers, bonusNumber);

        // then
        assertAll(
                () -> assertThat(lottoResultDto.getMatchThreeNumbers()).isEqualTo(2),
                () -> assertThat(lottoResultDto.getMatchFourNumbers()).isEqualTo(1),
                () -> assertThat(lottoResultDto.getMatchFiveNumbers()).isEqualTo(0),
                () -> assertThat(lottoResultDto.getMatchSixNumbersIncludeBonus()).isEqualTo(1),
                () -> assertThat(lottoResultDto.getMatchSixNumbers()).isEqualTo(1),
                () -> assertThat(lottoResultDto.getEarnRate()).isEqualTo(406012L)
        );
    }
}
