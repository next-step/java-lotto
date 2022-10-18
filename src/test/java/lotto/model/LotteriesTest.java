package lotto.model;

import lotto.model.enumeration.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    @Test
    public void 로또_당첨_검증() {
        Lotteries lotteries = new Lotteries(
                List.of(new Lotto(createLottoNumber(1, 2, 4, 24, 25, 45)),
                        new Lotto(createLottoNumber(1, 2, 3, 25, 35, 44)))
        );

        WinningLotto winningLotto = new WinningLotto(createLottoNumber(1, 2, 4, 24, 25, 45), new LottoNumber(44));
        Map<Rank, Long> result = lotteries.getLotteriesRank(winningLotto);

        assertThat(result).isEqualTo(Map.of(Rank.FIRST, 1L, Rank.FIFTH, 1L));
    }

    @Test
    public void 로또_당첨_보너스_볼_일치_검증() {
        Lotteries lotteries = new Lotteries(
                List.of(new Lotto(createLottoNumber(1, 2, 4, 24, 25, 45)),
                        new Lotto(createLottoNumber(1, 2, 3, 25, 35, 44)))
        );

        WinningLotto winningLotto = new WinningLotto(createLottoNumber(1, 2, 4, 24, 25, 43), new LottoNumber(45));
        Map<Rank, Long> result = lotteries.getLotteriesRank(winningLotto);

        assertThat(result).isEqualTo(Map.of(Rank.SECOND, 1L, Rank.FIFTH, 1L));
    }

    private List<LottoNumber> createLottoNumber(int... number) {
        return Arrays.stream(number)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}