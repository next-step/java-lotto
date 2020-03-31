package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static lotto.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    public void setUp() {
        lottoGame = new LottoGame();
    }

    @Test
    @DisplayName("입력된 로또와 당첨 로또의 일치하는 번호 갯수를 리턴한다")
    public void matchLottoNumberReturnsCountOfMatches() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int result = lottoGame.match(lotto, winningLotto);

        assertThat(result).isEqualTo(3);

        lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 5, 6, 10));

        result = lottoGame.match(lotto, winningLotto);

        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("일치한 번호 갯수를 입력하면 등수를 리턴한다")
    public void getRankReturnsRankOfLotto() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int matchCount = lottoGame.match(lotto, winningLotto);

        Rank result = lottoGame.getRank(matchCount);

        assertThat(result).isEqualTo(FOURTH);

        lotto = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        matchCount = lottoGame.match(lotto, winningLotto);

        result = lottoGame.getRank(matchCount);

        assertThat(result).isEqualTo(THIRD);
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
}
