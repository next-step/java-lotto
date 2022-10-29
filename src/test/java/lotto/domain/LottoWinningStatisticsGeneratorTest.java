package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningStatisticsGeneratorTest {

    @Test
    void createLottoWinningStatistics() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        List<Lotto> lottos = List.of(new Lotto(lottoNumbers));

        LottoNumbers winningLottoNumbers = new LottoNumbers(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(14),
                        new LottoNumber(15),
                        new LottoNumber(16)));
        LottoWinningStatistics lottoWinningStatistics =
                LottoWinningStatisticsGenerator.giveOut(14000, lottos, winningLottoNumbers);

        assertThat(lottoWinningStatistics)
                .isEqualTo(new LottoWinningStatistics(Map.of(LottoWinningType.FOURTH, 1), 0.35));
    }
}
