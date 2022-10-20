package lotto.model;

import lotto.model.enumeration.Rank;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.model.Profit.getReturnRate;
import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    @Test
    public void 로또_수익금_검증() {
        Map<Rank, Long> lotteriesRank = Map.of(Rank.FIRST, 1L, Rank.THIRD, 1L);

        double result = getReturnRate(lotteriesRank, 2001500000);

        assertThat(result).isEqualTo(1.0);
    }

    @Test
    public void 로또_수익금_없는_검증() {
        Map<Rank, Long> lotteriesRank = new HashMap<>();

        double result = getReturnRate(lotteriesRank, 14000);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 로또_당첨_검증() {
        Lotteries lotteries = new Lotteries(
                List.of(new Lotto(createLottoNumber(1, 2, 4, 24, 25, 45)),
                        new Lotto(createLottoNumber(1, 2, 3, 25, 35, 44)))
                , new ArrayList<>()
        );

        WinningLotto winningLotto = new WinningLotto(createLottoNumber(1, 2, 4, 24, 25, 45), new LottoNumber(44));
        Profit profit = new Profit(winningLotto);

        Map<Rank, Long> result = profit.getLotteriesRank(lotteries.getAllLotteries());

        assertThat(result).isEqualTo(Map.of(Rank.FIRST, 1L, Rank.FIFTH, 1L));
    }

    @Test
    public void 로또_당첨_보너스_볼_일치_검증() {
        Lotteries lotteries = new Lotteries(
                List.of(new Lotto(createLottoNumber(1, 2, 4, 24, 25, 45)),
                        new Lotto(createLottoNumber(1, 2, 3, 25, 35, 44)))
                , List.of(new Lotto(createLottoNumber(3, 4, 7, 22, 26, 43)))
        );

        WinningLotto winningLotto = new WinningLotto(createLottoNumber(1, 2, 4, 24, 25, 43), new LottoNumber(45));
        Profit profit = new Profit(winningLotto);

        Map<Rank, Long> result = profit.getLotteriesRank(lotteries.getAllLotteries());

        assertThat(result).isEqualTo(Map.of(Rank.SECOND, 1L, Rank.FIFTH, 1L, Rank.MISS, 1L));
    }

    private List<LottoNumber> createLottoNumber(int... number) {
        return Arrays.stream(number)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}