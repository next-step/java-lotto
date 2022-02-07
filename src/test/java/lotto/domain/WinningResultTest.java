package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Rank;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    @Test
    public void 당첨통계_맵핑_테스트() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 17));
        Lotto lotto4 = Lotto.from(Arrays.asList(1, 2, 3, 4, 15, 7));
        Lotto lotto5 = Lotto.from(Arrays.asList(1, 2, 3, 14, 15, 7));
        Lotto lotto6 = Lotto.from(Arrays.asList(1, 2, 13, 14, 15, 7));

        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);
        lottos.add(lotto5);
        lottos.add(lotto6);

        WinningNumber winningNumber = new WinningNumber(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));

        //when
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Set<LottoNumber> lottoNumbers = lotto.getNumbers();

            List<Integer> collect = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

            Rank rank = winningNumber.compareTo(collect);
            ranks.add(rank);
        }
        WinningResult winningResult = new WinningResult(ranks);

        //then
        assertThat(winningResult.getResult().get(Rank.FIRST)).isEqualTo(1);
        assertThat(winningResult.getResult().get(Rank.SECOND)).isEqualTo(1);
        assertThat(winningResult.getResult().get(Rank.THIRD)).isEqualTo(1);
        assertThat(winningResult.getResult().get(Rank.FOURTH)).isEqualTo(1);
        assertThat(winningResult.getResult().get(Rank.FIFTH)).isEqualTo(1);
        //assertThat(winningResult.getResult().get(Rank.NONE)).isEqualTo(0);
    }

    @Test
    void 당첨금액_계산() {
        //given
        List<Rank> ranks = new ArrayList<>();
        ranks.add(Rank.FIRST);
        ranks.add(Rank.SECOND);

        //when
        WinningResult winningResult = new WinningResult(ranks);

        winningResult.calculateTotalPrize();

        //then
        assertThat(winningResult.getWinningCash()).isEqualTo(2000000000 + 30000000);
    }
}