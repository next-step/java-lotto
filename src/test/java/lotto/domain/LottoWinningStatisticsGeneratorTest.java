package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningStatisticsGeneratorTest {

    @DisplayName("5등 확인")
    @Test
    void createLottoWinningStatistics_fifth() {
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
        LottoNumber bonusLottoNumber = new LottoNumber(45);
        LottoWinningStatistics lottoWinningStatistics =
                LottoWinningStatisticsGenerator.giveOut(14000, lottos,
                        winningLottoNumbers, bonusLottoNumber);

        assertThat(lottoWinningStatistics)
                .isEqualTo(new LottoWinningStatistics(Map.of(LottoWinningType.FIFTH, 1), 0.35));
    }

    @DisplayName("2등 확인")
    @Test
    void createLottoWinningStatistics_second() {
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
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(16)));
        LottoNumber bonusLottoNumber = new LottoNumber(6);
        LottoWinningStatistics lottoWinningStatistics =
                LottoWinningStatisticsGenerator.giveOut(14000, lottos,
                        winningLottoNumbers, bonusLottoNumber);

        assertThat(lottoWinningStatistics)
                .isEqualTo(new LottoWinningStatistics(Map.of(LottoWinningType.SECOND, 1), 2142.85));
    }

    @DisplayName("3등 확인")
    @Test
    void createLottoWinningStatistics_thrid() {
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
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(16)));
        LottoNumber bonusLottoNumber = new LottoNumber(26);
        LottoWinningStatistics lottoWinningStatistics =
                LottoWinningStatisticsGenerator.giveOut(14000, lottos,
                        winningLottoNumbers, bonusLottoNumber);

        assertThat(lottoWinningStatistics)
                .isEqualTo(new LottoWinningStatistics(Map.of(LottoWinningType.THIRD, 1), 107.14));
    }

}
