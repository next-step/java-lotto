package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRanksTest {

    @Test
    void 당첨_순위_일급_컬렉션_객체_생성_테스트() {
        WinningRanks winningRanks = new WinningRanks(Arrays.asList(Rank.FIRST));
        assertThat(winningRanks).isEqualTo(new WinningRanks(Arrays.asList(Rank.FIRST)));
    }

    @Test
    void 당첨_순위_집계_기능_테스트() {
        List<Rank> ranks = Arrays.asList(Rank.FOURTH, Rank.FOURTH);
        WinningRanks winningRanks = new WinningRanks(ranks);
        Map<Rank, Integer> aggregationRankMap = winningRanks.aggregateRank();
        assertThat(aggregationRankMap).containsKeys(Rank.FOURTH);
        assertThat(aggregationRankMap).containsValue(2);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "14000:FIFTH:0.35", "10000:FIFTH:0.5", "50000:FOURTH:1", "10000:FOURTH:5", "5000:FOURTH:10"
    }, delimiter = ':')
    void 당첨_수익률_계산_기능_테스트(int payment, Rank rank, double excepted) {
        LottoPayment lottoPayment = LottoPayment.create(payment);
        WinningRanks winningRanks = new WinningRanks(Arrays.asList(rank));
        double profitRate = winningRanks.calcProfitRate(lottoPayment);
        assertThat(profitRate).isEqualTo(excepted);

    }
}
