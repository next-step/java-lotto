package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.winning.WinningReward;
import lotto.domain.winning.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("결과 화면 테스트")
public class ResultViewTest {
    StringWriter output = new StringWriter();

    @DisplayName("구입한 로또 정렬해서 출력")
    @Test
    public void showLotto() {
        ResultView resultView = new ResultView(new PrintWriter(output));
        Lottos lottos = Lottos.of(Arrays.asList(
                Lotto.ofNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Lotto.ofNumbers(Arrays.asList(7, 3, 4, 5, 6, 2))));

        resultView.showLottos(lottos);

        assertThat(output.toString()).isEqualTo("2개를 구매했습니다.\n" +
                "[1, 2, 3, 4, 5, 6]\n" +
                "[2, 3, 4, 5, 6, 7]\n\n");
    }

    @DisplayName("1보다 낮은 수익률 결과 출력")
    @Test
    public void showResultWithRevenueLessThanOne() {
        ResultView resultView = new ResultView(new PrintWriter(output));

        resultView.showResult(WinningStatistics.of(new HashMap<WinningReward, Integer>() {{
            put(WinningReward.THREE, 1);
        }}), 0.5);

        assertThat(output.toString()).isEqualTo("\n당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- 1개\n" +
                "4개 일치 (50000원)- 0개\n" +
                "5개 일치 (1500000원)- 0개\n" +
                "5개 일치, 보너스 볼 일치(30000000원)- 0개\n" +
                "6개 일치 (2000000000원)- 0개\n" +
                "총 수익률은 0.50입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n");
    }

    @DisplayName("1이상인 수익률 결과 출력")
    @Test
    public void showResultWithRevenueMoreThanOne() {
        ResultView resultView = new ResultView(new PrintWriter(output));

        resultView.showResult(WinningStatistics.of(new HashMap<WinningReward, Integer>() {{
            put(WinningReward.THREE, 1);
        }}), 5.0);

        assertThat(output.toString()).isEqualTo("\n당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- 1개\n" +
                "4개 일치 (50000원)- 0개\n" +
                "5개 일치 (1500000원)- 0개\n" +
                "5개 일치, 보너스 볼 일치(30000000원)- 0개\n" +
                "6개 일치 (2000000000원)- 0개\n" +
                "총 수익률은 5.00입니다.\n");
    }
}