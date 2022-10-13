package lotto.model;

import lotto.model.enumeration.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    @Test
    public void 로또_당첨금_검증() {
        Map<Rank, Long> lotteriesRank = Map.of(Rank.FIRST, 2L, Rank.THIRD, 1L);

        Lotteries lotteries = createLotteries(3000);

        long result = lotteries.getTotalWinningMoney(lotteriesRank);

        assertThat(result).isEqualTo(4000050000L);
    }

    @Test
    public void 로또_당첨금_없는_검증() {
        Lotteries lotteries = createLotteries(3000);

        long result = lotteries.getTotalWinningMoney(new HashMap<>());

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 로또_당첨_검증() {
        Lotteries lotteries = new Lotteries(
                List.of(new Lotto(createLottoNumber(1, 2, 4, 24, 25, 45)),
                        new Lotto(createLottoNumber(1, 2, 3, 25, 35, 44)))
        );

        List<LottoNumber> lastWinLotto = createLottoNumber(1, 2, 4, 24, 25, 45);

        Map<Rank, Long> result = lotteries.getLotteriesRank(lastWinLotto);

        assertThat(result).isEqualTo(Map.of(Rank.FIRST, 1L, Rank.FOURTH, 1L));
    }

    private Lotteries createLotteries(int amount) {
        return new Lotteries(new LottoMachine(), amount);
    }

    private List<LottoNumber> createLottoNumber(int... number) {
        return Arrays.stream(number)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}