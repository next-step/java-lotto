package lotto.domain;

import lotto.data.LottoBall;
import lotto.data.LottoWinInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinLottoBallsTest {

    @DisplayName("5개가 맞았을 때, 보너스점수 까지 맞으면 WIN_FIRST_WITH_BONUS 이다.")
    @Test
    void enumWinFirstWithBonusWhenMatchedFiveWithBonusNumber() {
        // given
        Lotto mySelect = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoBall bonusNumber = LottoBall.selectLottoBall(6);

        // when
        WinLottoBalls winLottoBalls = new WinLottoBalls(
                winningNumber,
                bonusNumber
        );

        // then
        LottoWinInfo lottoWinInfo = winLottoBalls.countMatchWithBonus(
                mySelect
        );
        assertThat(lottoWinInfo).isEqualTo(LottoWinInfo.WIN_FIRST_WITH_BONUS);
    }

    @DisplayName("5개가 맞았을 때, 보너스점수가 맞지 않으면 WIN_SECOND이다.")
    @Test
    void enumWinSecondWhenMatchedFiveWithoutBonusNumber() {
        // given
        Lotto mySelect = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoBall bonusNumber = LottoBall.selectLottoBall(10);

        // when
        WinLottoBalls winLottoBalls = new WinLottoBalls(
                winningNumber,
                bonusNumber
        );

        // then
        LottoWinInfo lottoWinInfo = winLottoBalls.countMatchWithBonus(
                mySelect
        );
        assertThat(lottoWinInfo).isEqualTo(LottoWinInfo.WIN_SECOND);
    }

    @DisplayName("보너스번호가 당첨번호와 중복되면, IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionWhenBonusDuplicate() {
        // then
        assertThrows(IllegalArgumentException.class,
                () -> new WinLottoBalls(new Lotto(List.of(1, 2, 3, 4, 5, 6)), LottoBall.selectLottoBall(1))
        );
    }
}
