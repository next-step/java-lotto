package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankCollectorTest {

    @Test
    @DisplayName("1등 당첨 로또를 소지한 경우 1등 랭크가 잘 나오는지 확인")
    public void 일등_당첨_로또를_소지한_경우_랭크_1등_확인() {

        LottoRankCollector collector = new LottoRankCollector(Arrays.asList(
                // 소지한 로또 1
                new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::new)
                        .collect(toList())),
                // 소지한 로또 2
                new Lotto(IntStream.rangeClosed(7, 12)
                        .mapToObj(LottoNumber::new)
                        .collect(toList()))),

                // 당첨번호
                new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::new)
                        .collect(toList())),
                new LottoNumber(45));

        List<LottoRank> rankList = collector.getRankList();

        assertThat(rankList.contains(LottoRank.FIRST)).isTrue();

    }


}