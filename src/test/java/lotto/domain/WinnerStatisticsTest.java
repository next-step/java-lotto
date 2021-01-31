package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerStatisticsTest {
    private final static int PURCHASE_LOTTO_AMOUNT = 3_000;

    @DisplayName("1등 1개, 2등 1개, 꽝 1개")
    @Test
    void getResult() {
        // given
        WinnerStatistics winnerStatistics = createWinnerStatistics();

        // when
        EnumMap<Rank, Integer> result = winnerStatistics.getResults();

        // then
        assertThat(result.getOrDefault(Rank.FIRST, 0)).isEqualTo(1);
        assertThat(result.getOrDefault(Rank.SECOND, 0)).isEqualTo(1);
        assertThat(result.getOrDefault(Rank.NONE, 0)).isEqualTo(1);
    }

    @DisplayName("3개 구입하여 1등 1개, 2등 1개일 때 수익률을 확인")
    @Test
    void getEarningRateTest() {
        // given
        WinnerStatistics winnerStatistics = createWinnerStatistics();

        // when
        double earningRate = winnerStatistics.getEarningRate();

        // then
        assertThat(earningRate).isEqualTo(676666.66);
    }

    private WinnerStatistics createWinnerStatistics() {
        LottoTicket winningTicket = createWinningTicket();
        LottoNumber bonusNumber = new LottoNumber(45);
        GoldenTicket goldenTicket = new GoldenTicket(winningTicket, bonusNumber);

        Tickets lottoTickets = new MockLottoTickets(Arrays.asList(
                createPickedWinningNumbers(),
                createPickedSecondNumbers(),
                createPickedFailNumbers()
        ), PURCHASE_LOTTO_AMOUNT);

        return new WinnerStatistics(goldenTicket, lottoTickets);
    }

    private LottoTicket createWinningTicket() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        );
        return new LottoTicket(lottoNumbers);
    }

    private LottoTicket createPickedWinningNumbers() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(43)
        );
        return new LottoTicket(lottoNumbers);
    }

    private LottoTicket createPickedSecondNumbers() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(8),
                new LottoNumber(21),
                new LottoNumber(23),
                new LottoNumber(41),
                new LottoNumber(42),
                new LottoNumber(45)
        );
        return new LottoTicket(lottoNumbers);
    }

    private LottoTicket createPickedFailNumbers() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
        return new LottoTicket(lottoNumbers);
    }
}