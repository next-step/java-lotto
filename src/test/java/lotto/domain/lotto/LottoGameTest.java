package lotto.domain.lotto;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("LottoGame 클래스 테스트")
public class LottoGameTest {

    @DisplayName("LottoTicket, WinningNumbers를 전달받아 로또 게임을 진행할 수 있다.")
    @Test
    void execute() {
        Price price = new Price(2000);
        String winningNumberString = "1,2,3,4,5,6";
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberString);

        LottoGame lottoGame = new LottoGame(price, new LottoTicket(price, new LottoNumberGenerator()));

        WinningStatistics winningStatistics = lottoGame.execute(winningNumbers);

        assertThat(winningStatistics.getPrice()).isEqualTo(price);
    }
}
