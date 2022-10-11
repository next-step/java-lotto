package lotto.services;

import lotto.models.Lotto;
import lotto.models.LottoStatistics;
import lotto.models.enums.Rank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsServiceTest {

    private static final LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();
    private static final List<Lotto> lottos = new ArrayList<>();
    private static final String WINNING_NUMBER = "1, 2, 3, 4, 5, 6";
    private static final List<Lotto> duplicatedLottos = new ArrayList<>();
    private static final int PAYMENT = 3500;
    private static Lotto winningLotto;

    @BeforeAll
    static void setLotto() {
        lottos.add(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(Lotto.of(List.of(1, 2, 3, 7, 8, 9)));
        lottos.add(Lotto.of(List.of(11, 12, 13, 14, 15, 16)));
    }

    @BeforeAll
    static void setDuplicatedLottos() {
        duplicatedLottos.add(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
        duplicatedLottos.add(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
        duplicatedLottos.add(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
    }

    @BeforeAll
    static void setWinningLotto() {
        List<Integer> splitNumbers = Arrays.stream(WINNING_NUMBER.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());

        winningLotto = Lotto.of(splitNumbers);
    }

    @Test
    @DisplayName("당첨번호와 로또번호 리스트를 받으면 각 Rank가 몇 개씩 당첨됐는지 가져온다.")
    void createStatistics() {
        List<LottoStatistics> lottoStatistics = lottoStatisticsService.getLottoStatistics(lottos, winningLotto);

        lottoStatistics.forEach(statistics -> {
            if (statistics.getRank().equals(Rank.FIRST)) {
                assertThat(statistics.getCount()).isEqualTo(1);
            } else if (statistics.getRank().equals(Rank.FOURTH)) {
                assertThat(statistics.getCount()).isEqualTo(1);
            } else if (statistics.getRank().equals(Rank.OTHER)) {
                assertThat(statistics.getCount()).isEqualTo(1);
            }
        });
    }

    @Test
    @DisplayName("6개 모두 당첨된 복권 3개가 발행된 경우 Rank.FIRST의 count가 3이다.")
    void createStatistics2() {
        List<LottoStatistics> lottoStatistics = lottoStatisticsService.getLottoStatistics(duplicatedLottos, winningLotto);

        lottoStatistics.forEach(statistics -> {
            if (statistics.getRank().equals(Rank.FIRST)) {
                assertThat(statistics.getCount()).isEqualTo(3);
            }
        });
    }

    @Test
    @DisplayName("통계치와 지불한 금액을 전달하면 이율을 리턴한다.")
    void getRevenueRatio() {
        List<LottoStatistics> lottoStatistics = lottoStatisticsService.getLottoStatistics(lottos, winningLotto);
        long totalAmount = lottoStatistics.stream()
                .filter(statistics -> statistics.getCount() > 0)
                .map(statistics -> statistics.getRank().getAmount())
                .mapToLong(Long::longValue)
                .sum();

        assertThat(lottoStatisticsService.getRevenueRatio(lottoStatistics, PAYMENT)).isEqualTo(totalAmount / (PAYMENT / 1000f * 1000));
    }

}
