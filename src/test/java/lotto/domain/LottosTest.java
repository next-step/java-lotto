package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    List<LottoNumber> numbers;
    Lottos lottos;

    @BeforeEach
    void init() {
        numbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );

        lottos = new Lottos(Arrays.asList(
                // 1등
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
                )),
                // 2등
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(7)
                )),
                // 3등
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(8)
                )),
                // 5등
                new Lotto(Arrays.asList(
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6),
                        new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)
                )),
                // MISS
                new Lotto(Arrays.asList(
                        new LottoNumber(8), new LottoNumber(9), new LottoNumber(10),
                        new LottoNumber(11), new LottoNumber(12), new LottoNumber(13)
                ))
        ));

    }

    @Test
    void orderByKey() {
        SortedMap<LottoRank, Integer> lottoStatisticMap = new TreeMap<>();
        lottoStatisticMap.put(LottoRank.THIRD, 2);
        lottoStatisticMap.put(LottoRank.MISS, 3);
        lottoStatisticMap.put(LottoRank.FIFTH, 2);
        lottoStatisticMap.put(LottoRank.FIRST, 1);
        lottoStatisticMap.put(LottoRank.FOURTH, 3);
        LottoStatistic expected = new LottoStatistic(lottoStatisticMap);
        expected.toFormattingStringList().forEach(System.out::println);
    }

    @Test
    @DisplayName("당첨 통계 계산하기")
    void makeStatistic() {
        // given
        Lotto luckyLotto = new Lotto(numbers);
        LottoNumber bonusNumber = new LottoNumber(7);

        // when
        LottoStatistic actual = lottos.makeStatistic(luckyLotto, bonusNumber);

        // then
        SortedMap<LottoRank, Integer> lottoStatisticMap = new TreeMap<>();
        lottoStatisticMap.put(LottoRank.FIRST, 1);
        lottoStatisticMap.put(LottoRank.SECOND, 1);
        lottoStatisticMap.put(LottoRank.THIRD, 1);
        lottoStatisticMap.put(LottoRank.FIFTH, 1);
        //lottoStatisticMap.put(LottoRank.MISS, 1);
        LottoStatistic expected = new LottoStatistic(lottoStatisticMap);
        assertThat(actual).isEqualTo(expected);
    }

}
