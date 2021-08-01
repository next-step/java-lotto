package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinStatisticsTest {
    @Test
    @DisplayName("수익률 계산 테스트")
    void getProfitRateTest() {
        List<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6).collect(Collectors.toList());

        LottoWinStatistics lottoWinStatistics = new LottoWinStatistics(new Lotto(numbers));

        List<Lotto> lottoes = Stream.of(
                new Lotto(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),  // none match case
                new Lotto(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
                new Lotto(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
                new Lotto(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
                new Lotto(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
                new Lotto(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
                new Lotto(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
                new Lotto(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
                new Lotto(Stream.of(10, 11, 12, 13, 14, 15).collect(Collectors.toList())),
                new Lotto(Stream.of(1, 2, 3, 10, 11, 12).collect(Collectors.toList()))  // three match case
        ).collect(Collectors.toList());

        lottoWinStatistics.addLottoSamples(lottoes);

        assertThat(lottoWinStatistics.getProfitRate(1000)).isEqualTo(0.5);  //  5000원(3개 일치 - 1장) / 10000원 구매(10장)
    }
}
