package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningInformation;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static lotto.domain.WinningInformation.THREE_MATCHES;
import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("주어진 로또의 개수와, 로또 숫자들을 출력한다.")
    @Test
    void print_generated_lotto() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 3, 5, 6, 7, 9)),
                new Lotto(List.of(2, 4, 6, 8, 10, 12))
        );
        String expected = "3개를 구매했습니다.\n" +
                "[1, 2, 3, 4, 5, 6]\n" +
                "[1, 3, 5, 6, 7, 9]\n" +
                "[2, 4, 6, 8, 10, 12]";

        OutputView.printGeneratedLottos(lottos);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("당첨 통계를 출력한다.")
    @Test
    void print_winning_statistics() {
        String expected = "당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- 1개\n" +
                "4개 일치 (50000원)- 0개\n" +
                "5개 일치 (1500000원)- 0개\n" +
                "6개 일치 (2000000000원)- 0개\n" +
                "총 수익률은 0.35입니다.";
        List<WinningInformation> winningInformations = List.of(THREE_MATCHES);
        WinningStatistics winningStatistics = new WinningStatistics(winningInformations);

        OutputView.printWinningStatistics(winningStatistics, new Money(14000));
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("주어진 로또의 개수와, 로또 숫자들을 출력한다.")
    @Test
    void print_left_money() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 3, 5, 6, 7, 9)),
                new Lotto(List.of(2, 4, 6, 8, 10, 12))
        );
        String expected = "3개를 구매했습니다.\n" +
                "[1, 2, 3, 4, 5, 6]\n" +
                "[1, 3, 5, 6, 7, 9]\n" +
                "[2, 4, 6, 8, 10, 12]";

        OutputView.printGeneratedLottos(lottos);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}