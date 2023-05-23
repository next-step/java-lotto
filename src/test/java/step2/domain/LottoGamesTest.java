package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGamesTest {

    LottoGames lottoGames = new LottoGames();

    @DisplayName("개수만큼 로또 게임을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {12, 100, 30, 17})
    public void n개의_게임_생성(int gameCount) throws Exception {
        assertThat(lottoGames.buyAutomaticLottoTickets(gameCount)).size()
                .isEqualTo(gameCount);
    }

    @DisplayName("지난주 당첨 번호를 읽어온다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1, 2, 12, 23, 35, 36", "7, 8, 22,23, 35,43"})
    public void 지난주_당첨_번호_파싱(String winningNumbers) throws Exception {
        String[] split = winningNumbers.split(",");
        assertThat(lottoGames.toLottoTicket(split));
    }

    @DisplayName("지난주 당첨 번호를 읽는 과정에서 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, &, 4, %, 6", "*, 2, 12, 23, 35, 36"})
    public void 지난주_당첨_번호_파싱_예외(String winningNumbers) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoGames.toLottoTicket(winningNumbers.split(",")));
    }
}
