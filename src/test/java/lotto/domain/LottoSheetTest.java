package lotto.domain;

import lotto.data.LottoBall;
import lotto.dto.LottoResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoSheetTest {

    @DisplayName("구매한 돈 만큼의 로또를 구매한다(1000원 단위).")
    @Test
    void buyLottoByMoney() {
        // given
        int purchasedPrice = 18000;
        LottoSheet lottoSheet = new LottoSheet(purchasedPrice);

        // when
        int lottoSize = lottoSheet.purchasedCount();

        // then
        assertThat(lottoSize).isEqualTo(18);
    }

    @DisplayName("로또 당첨 결과를 확인한다.")
    @Test
    void matchWinningLottoNumbers() {
        // given
        int purchasedPrice = 5000;
        List<Lotto> manualLottoNumbers = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 35))

        );
        LottoSheet lottoSheet = new LottoSheet(purchasedPrice, manualLottoNumbers);

        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoBall bonusNumber = LottoBall.selectLottoBall(35);

        // when
        LottoResultDto lottoResultDto = lottoSheet.matchWin(new WinLottoBalls(winningNumbers, bonusNumber));

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

    @DisplayName("구매한 자동 로또수를 반환한다.")
    @Test
    void countAutoLotto() {
        // given
        int purchasedPrice = 18000;
        List<Lotto> manualLottoNumbers = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 35))

        );
        LottoSheet lottoSheet = new LottoSheet(purchasedPrice, manualLottoNumbers);

        // then
        assertThat(lottoSheet.countAuto()).isEqualTo(13);
    }

    @DisplayName("구매한 수동 로또수를 반환한다.")
    @Test
    void countManualLotto() {
        // given
        int purchasedPrice = 18000;
        List<Lotto> manualLottoNumbers = List.of(
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 35))

        );
        LottoSheet lottoSheet = new LottoSheet(purchasedPrice, manualLottoNumbers);

        // then
        assertThat(lottoSheet.countManual()).isEqualTo(5);
    }
}
