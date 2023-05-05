package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGamesTest {

    static final int DEFAULT_LOTTO_PRICE = 1000;

    LottoGames lottoGames = new LottoGames();

    @DisplayName("전달받은 금액으로 구매가능한 게임 개수를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3000, 4000, 15000, 34000})
    public void 구매가능_게임_개수(int money) throws Exception {
        assertThat(lottoGames.howManyBuyGames(money)).isEqualTo(money / DEFAULT_LOTTO_PRICE);
    }

    @DisplayName("개수만큼 로또 게임을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {12, 100, 30, 17})
    public void n개의_게임_생성(int gameCount) throws Exception {
        assertThat(lottoGames.buyLottoGame(gameCount)).size()
                .isEqualTo(gameCount);
    }

    @DisplayName("지난주 당첨 번호를 읽어온다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1, 2, 12, 23, 35, 36", "7, 8, 22,23, 35,43"})
    public void 지난주_당첨_번호_파싱(String winningNumbers) throws Exception {
        assertThat(lottoGames.readWinningNumber(winningNumbers));
    }

    @DisplayName("지난주 당첨 번호를 읽는 과정에서 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, &, 4, %, 6", "*, 2, 12, 23, 35, 36", "1, 12, 8, 22,23, 35,43"})
    public void 지난주_당첨_번호_파싱_예외(String winningNumbers) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoGames.readWinningNumber(winningNumbers));
    }

    @DisplayName("당첨금에 따른 수익률을 계산한다.")
    @ParameterizedTest
    @MethodSource("lottoReportSample")
    public void 수익률_연산(int[] lottoReport, int sum) throws Exception {
        assertThat(lottoGames.sum(lottoReport)).isEqualTo(sum);
    }

    static Stream<Arguments> lottoReportSample() throws Throwable {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 1, 0, 0, 0, 0}, 0),
                Arguments.of(new int[]{0, 0, 0, 1, 0, 0, 0}, 5000),
                Arguments.of(new int[]{0, 0, 0, 0, 1, 0, 0}, 50000),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 1, 0}, 1500000),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 1}, 2000000000),
                Arguments.of(new int[]{0, 0, 0, 1, 0, 1, 1}, 2001505000)


        );
    }

}
