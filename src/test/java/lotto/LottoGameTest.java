package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {
    private LottoGame lottoGame = new LottoGame();
    private WinningLotto winningLotto;

    @BeforeEach
    public void setUp() {
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test
    @DisplayName("일치한 번호 갯수를 입력하면 등수를 리턴한다")
    public void matchLottoAndWinningLottoReturnsResultsOfLottos() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12))
        );

        List<Rank> results = lottoGame.match(lottos, winningLotto);

        assertThat(results).contains(FIFTH);
        assertThat(results).hasSize(2);
    }

    @Test
    @DisplayName("5개의 번호가 일치하고 보너스 번호가 일치하면 2등이다")
    public void matchFiveNumbersAndContainBonusIsSecond() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));

        List<Rank> results = lottoGame.match(lottos, winningLotto);

        assertThat(results).contains(SECOND);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2"})
    @DisplayName("로또의 구매 금액을 입력하면 구매한 로또 장수를 리턴한다")
    public void purchaseLottoReturnsCountOfLottoTickets(int price, int count) {
        int result = lottoGame.purchaseLotto(price);

        assertThat(result).isEqualTo(count);
    }

    @Test
    @DisplayName("구매 금액이 한 장 값보다 작으면 IllegalArgumentException")
    public void inputPriceLowerThanOneLottoPriceThrowException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoGame.purchaseLotto(500));
    }

    @Test
    @DisplayName("당첨 결과를 입력하면 당첨금 총액을 리턴한다")
    public void returnsTotalWinningsWhenInputRankOfAllLotto() {
        int result = lottoGame.getTotalWinnings(Arrays.asList(FIRST, SECOND));

        assertThat(result).isEqualTo(FIRST.getWinningMoney() + SECOND.getWinningMoney());
    }

    @ParameterizedTest
    @ValueSource(ints = {14000, 5000})
    @DisplayName("당첨금 총액과 구매 금액을 이용하여 수익률을 계산한다")
    public void calculateRateOfRevenueByTotalWinningsAndPrice(int price) {
        int totalWinnings = lottoGame.getTotalWinnings(Arrays.asList(FOURTH));

        double result = lottoGame.getRateOfRevenue(price, totalWinnings);

        assertThat(result).isEqualTo((double) totalWinnings / price);
    }

    @Test
    @DisplayName("수동으로 입력된 로또 개수와 자동 구매 장숨나큼 로또를 생성한다")
    public void autoCreateLottoAsMuchAsPurchaseCount() {
        List<Lotto> manualLottoNumbers = Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42 ,43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44))
        );
        List<Lotto> lottos = lottoGame.createLottos(manualLottoNumbers, 11);

        assertThat(lottos).hasSize(14);
    }
}
