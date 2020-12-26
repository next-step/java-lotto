package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    List<LottoNumber> numbers;

    @BeforeEach
    void init() {
        numbers = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        );
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

        int[] matchingCounts = new int[]{
            0, 1, 2,
            3, 3,
            4, 4, 4,
            5, 5,
            6
        };

        SortedMap<LottoRank, Integer> lottoStatisticMap = new TreeMap<>();
        for (int matchingCount : matchingCounts) {
            LottoRank rank = LottoRank.valueOf(matchingCount, false);
            Lottos.putLottoStatisticMap(lottoStatisticMap, rank);
        }
        LottoStatistic actual = new LottoStatistic(lottoStatisticMap);

        SortedMap<LottoRank, Integer> expectedLottoStatisticMap = new TreeMap<>();
        expectedLottoStatisticMap.put(LottoRank.FIRST, 1);
        expectedLottoStatisticMap.put(LottoRank.THIRD, 2);
        expectedLottoStatisticMap.put(LottoRank.FOURTH, 3);
        expectedLottoStatisticMap.put(LottoRank.FIFTH, 2);
        //lottoStatisticMap.put(LottoRank.MISS, 3);
        LottoStatistic expected = new LottoStatistic(expectedLottoStatisticMap);

        actual.toFormattingStringList().forEach(System.out::println);
        assertThat(actual).isEqualTo(expected);

    }

    @Test
    @DisplayName("당첨 통계에 2등 추가")
    void makeStatisticAdd2nd() {

        int[] matchingCounts = new int[]{5, 5, 5};
        boolean[] matchingBonus = new boolean[]{true, false, true};

        SortedMap<LottoRank, Integer> lottoStatisticMap = new TreeMap<>();
        for (int i = 0; i < matchingCounts.length; i++) {
            LottoRank rank = LottoRank.valueOf(matchingCounts[i], matchingBonus[i]);
            Lottos.putLottoStatisticMap(lottoStatisticMap, rank);
        }
        LottoStatistic actual = new LottoStatistic(lottoStatisticMap);

        SortedMap<LottoRank, Integer> expectedLottoStatisticMap = new TreeMap<>();
        expectedLottoStatisticMap.put(LottoRank.SECOND, 2);
        expectedLottoStatisticMap.put(LottoRank.THIRD, 1);
        LottoStatistic expected = new LottoStatistic(expectedLottoStatisticMap);

        actual.toFormattingStringList().forEach(System.out::println);
        expected.toFormattingStringList().forEach(System.out::println);
        assertThat(actual).isEqualTo(expected);

    }

}
