package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class RankingTest {

    @Test
    void 우승순위_조회(){
        // when
        Ranking ranking = Ranking.of(6, false);

        // then
        assertThat(ranking).isEqualTo(Ranking.ONE);
    }

    @Test
    void 당첨_번호와_몇개가_일치하는지_판단할_수_있다() {
        // given
        Lotto lotteryNumbers = Lotto.of(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)).stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));
        LottoNumber bounusNum = LottoNumber.from(8);
        Lotto userNumbers = Lotto.of(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8)).stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));

        // when
        Ranking lottoResult = Ranking.of(userNumbers,
            new WinningLotto(lotteryNumbers, bounusNum));

        // then
        assertThat(lottoResult).isEqualTo(Ranking.TWO);
    }
}
