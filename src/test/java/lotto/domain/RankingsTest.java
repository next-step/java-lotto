package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RankingsTest {

    Lotto lotteryNumbers;
    LottoNumber bounusNum;
    Lotto userNumbers;
    Lotto userNumbers2;
    List<Lotto> userlottos;

    @BeforeEach
    void setUp(){
        lotteryNumbers = Lotto.of(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList())));
        bounusNum = LottoNumber.from(8);
        userNumbers = Lotto.of(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8).stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList())));
        userNumbers2 = Lotto.of(
            new ArrayList<>(Arrays.asList(10, 11, 12, 13, 14, 15).stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList())));
        userlottos = new ArrayList<>();
        userlottos.add(userNumbers);
        userlottos.add(userNumbers2);
    }

    @Test
    void 상금총합_계산() {
        // when
        Rankings lottoResult = Rankings.of(new Lottos(userlottos),
            new WinningLotto(lotteryNumbers, bounusNum));

        // then
        assertThat(lottoResult.countWinnerPriceSum()).isEqualTo(30000000);
    }

    @Test
    void 특정랭킹_당첨된_횟수세기() {
        // when
        Rankings lottoResult = Rankings.of(new Lottos(userlottos),
            new WinningLotto(lotteryNumbers, bounusNum));

        // then
        assertThat(lottoResult.countFrequency(Ranking.TWO)).isEqualTo(1);
    }

    @Test
    void 특정랭킹_당첨된_횟수세기3() {
        // when
        Rankings lottoResult = Rankings.of(new Lottos(userlottos),
            new WinningLotto(lotteryNumbers, bounusNum));

        // then
        assertThat(lottoResult.countRewardRate(new Price(2000))).isEqualTo(15000);
    }
}
