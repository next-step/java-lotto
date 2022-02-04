package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoManager;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    @Test
    public void _1등_1개_2등_1개() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));
        lottos.add(lotto1);
        lottos.add(lotto2);

        WinningNumber winningNumber = new WinningNumber(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));

        WinningResult winningResult = new WinningResult();

        //when
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            List<LottoNumber> numbers = lotto.getNumbers();

            List<Integer> collect = numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

            Rank rank = winningNumber.compareTo(collect);
            ranks.add(rank);
        }

        winningResult.result(ranks);

        //then
        Assertions.assertThat(winningResult.getResult().get(Rank.FIRST)).isEqualTo(1);
        Assertions.assertThat(winningResult.getResult().get(Rank.SECOND)).isEqualTo(1);
    }
}