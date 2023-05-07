package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@DisplayName("승리 로또 생성 테스트")
class WinningLottoFactoryTest {

    @DisplayName("중복된 번호가 있으면 승리 로또도 생성에 실패한다")
    @Test
    void winningLotto_fail() {
        String winningNumbersString = "1,2,3,4,5,5";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottoFactory.create(winningNumbersString));
    }

    @DisplayName("중복된 번호가 없으면 승리 로또도 생성에 성공한다")
    @Test
    void winningLotto_success() {
        String winningNumbersString = "1,2,3,4,5,6";
        WinningLotto winningLotto = WinningLottoFactory.create(winningNumbersString);
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoTicket lottoTicket = winningLotto.findWinningLotto();
        int winningCount = lottoTicket.matchesLottoNumberCount(winningNumbers);

        Assertions.assertThat(winningCount).isEqualTo(6);
    }

    @DisplayName("당첨번호와 보너스 번호가 중복되면 예외가 발생한다")
    @Test
    void winningLotto_create_fail() {
        String winningNumbersString = "1,2,3,4,5,6";
        Integer bonusNumber = 6;
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottoFactory.create(winningNumbersString, bonusNumber))
                .withMessage("보너스 번호는 당첨 번호와 중복되지 않아야 합니다");
    }
}
