package lotto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 구매금액만큼_로또를_최대치_구입한다() {
        int lottoPrice = 1000;
        int purchase = 14000;

        List<Lotto> lottos = IntStream.rangeClosed(1, purchase / lottoPrice).mapToObj(i -> new Lotto()).collect(Collectors.toList());
        assertThat(lottos).hasSize(purchase / lottoPrice);
    }

    @Test
    void 몇개_맞았는지_계산해주기() {
        List<Integer> winLotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> myLotto = List.of(1, 2, 3, 7, 8, 9);

        int count = 0;
        for (Integer num : myLotto) {
            if (winLotto.contains(num)) {
                count++;
            }
        }

        assertThat(count).isEqualTo(3);
    }

    /**
     * 수익률 = 총 당첨 금액 / 구입 금액
     */
    @Test
    void statistics_on_matched_count() {
        long purchase = 14000L;

        Map<RANK, Integer> lotteryWin = new HashMap<>();
        lotteryWin.put(RANK.FOURTH, 1);
        lotteryWin.put(RANK.THIRD, 0);
        lotteryWin.put(RANK.SECOND, 0);
        lotteryWin.put(RANK.FIRST, 0);

        long totalPrize = lotteryWin.keySet().stream().mapToLong(key -> key.winPrize(lotteryWin.get(key))).sum();

        double actual = Math.floor((double) totalPrize / purchase * 100) / 100.0 ;
        assertThat(actual).isEqualTo(0.35);
    }
}