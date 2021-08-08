package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchStatisticsTest {
    private final LottoPrice lottoPrice = new LottoPrice(1000);
    private final List<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());
    private final LottoEntry[] lottoEntries = new LottoEntry[] {
            new LottoEntry(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),  // none match case
            new LottoEntry(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
            new LottoEntry(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
            new LottoEntry(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
            new LottoEntry(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
            new LottoEntry(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
            new LottoEntry(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
            new LottoEntry(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
            new LottoEntry(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
            new LottoEntry(Stream.of(1, 2, 3, 10, 11, 12).collect(Collectors.toList()))  // three match case
    };

    @Test
    @DisplayName("수익률 계산 테스트")
    void getProfitRateTest() {
        LottoWinStatistics lottoWinStatistics = new LottoWinStatistics(lottoPrice, new DrawnLotto(numbers, 45));

        LottoBucket lottoBucket = new LottoBucket();
        Stream.of(lottoEntries).forEach(lottoBucket::add);

        lottoWinStatistics.addLottoSamples(lottoBucket);

        assertThat(lottoWinStatistics.getProfitRate()).isEqualTo(0.5);  //  5000원(3개 일치 - 1장) / 10000원 구매(10장)
    }

    @Test
    @DisplayName("등수별 갯수 구하는 테스트")
    void countLottoEntryByLottoWinTest() {
        LottoWinStatistics lottoWinStatistics = new LottoWinStatistics(lottoPrice, new DrawnLotto(numbers, 45));

        LottoBucket lottoBucket = new LottoBucket();
        Stream.of(lottoEntries).forEach(lottoBucket::add);

        lottoWinStatistics.addLottoSamples(lottoBucket);

        assertThat(lottoWinStatistics.countLottoEntriesByMatch(Match.THREE_MATCH)).isEqualTo(1);

        assertThat(lottoWinStatistics.countLottoEntriesByMatch(Match.FOUR_MATCH)).isEqualTo(0);
    }
}
