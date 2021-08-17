package lotto.view;

import lotto.domain.Money;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private ByteArrayOutputStream out;
    private OutputView outputView;

    @BeforeEach
    public void setUp() {
        out = new ByteArrayOutputStream();
        outputView = OutputView.of(new PrintStream(out));
    }

    @ParameterizedTest(name = "2등 당첨 통계는 '보너스 볼 일치' 라는 문구를 포함한다.")
    @CsvSource(value = {"SECOND, true", "THIRD, false", "FIRST, false"})
    public void secondRankMatchResultTest(Rank rank, boolean containBonusBallMatchMessage) {
        outputView.printMatchCount(rank, 1);
        assertThat(out.toString().contains("보너스 볼 일치"))
                .isEqualTo(containBonusBallMatchMessage);
    }

    @ParameterizedTest(name = "수익률을 기준으로 손해 또는 이득이라는 문구를 포함한다.")
    @CsvSource(value = {"10000,1000,손해", "10000,15000,이득"})
    public void lotteryYieldResultTest(long purchaseAmount, long winningAmount, String resultMessage) {
        outputView.printLotteryYield(Money.of(purchaseAmount), Money.of(winningAmount));
        assertThat(out.toString()).contains(resultMessage);
    }

}