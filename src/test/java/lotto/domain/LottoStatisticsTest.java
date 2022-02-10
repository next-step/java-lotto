package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    @DisplayName(value = "번호 6개를 다 맞추면 1등이다.")
    @Test
    void firstGrade() {
        WinningLottery winningNumbers = new WinningLottery(
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)), new LottoNumber(10));

        List<Lotto> lottoList = new ArrayList<>();
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        lottoList.add(new Lotto(lottoNumberList.stream().collect(Collectors.toSet())));

        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, lottoList);
        assertThat(lottoStatistics.getResultStatistics().get(0)).isEqualTo(Rank.FIRST);
    }

    @DisplayName(value = "로또 번호를 3개 미만으로 맞추면 꽝이다.")
    @Test
    void 꽝() {
        WinningLottery winningNumbers = new WinningLottery(
            Arrays.asList(new LottoNumber(11), new LottoNumber(12), new LottoNumber(13),
                new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)), new LottoNumber(10));

        List<Lotto> lottoList = new ArrayList<>();
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        lottoList.add(new Lotto(lottoNumberList.stream().collect(Collectors.toSet())));

        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, lottoList);
        assertThat(lottoStatistics.getResultStatistics().get(0)).isEqualTo(Rank.NONE);
    }
}
