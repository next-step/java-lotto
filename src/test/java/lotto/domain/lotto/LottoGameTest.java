package lotto.domain.lotto;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("LottoGame 클래스 테스트")
public class LottoGameTest {

    @DisplayName("LottoTicket, WinningNumbers를 전달받아 로또 게임을 진행할 수 있다.")
    @Test
    void execute() {
        int lottoCount = 2;
        String winningNumberString = "1,2,3,4,5,6";

        LottoGame lottoGame = new LottoGame(new LottoTicket(lottoCount, new LottoNumberGenerator()),
                new WinningNumbers(winningNumberString));

        assertThatCode(lottoGame::execute).doesNotThrowAnyException();
    }
}
