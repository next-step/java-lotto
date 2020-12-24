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
        LottoNumber bonusNumber = new LottoNumber(7);
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(numbers, 0), new Lotto(numbers, 1), new Lotto(numbers, 2),
                new Lotto(numbers, 3), new Lotto(numbers, 3),
                new Lotto(numbers, 4), new Lotto(numbers, 4), new Lotto(numbers, 4),
                new Lotto(numbers, 5), new Lotto(numbers, 5),
                new Lotto(numbers, 6)
        );
        Lottos lottos = new Lottos(lottoList);
        LottoStatistic actual = lottos.makeStatistic(bonusNumber);
        SortedMap<LottoRank, Integer> lottoStatisticMap = new TreeMap<>();
        lottoStatisticMap.put(LottoRank.FIRST, 1);
        lottoStatisticMap.put(LottoRank.THIRD, 2);
        lottoStatisticMap.put(LottoRank.FOURTH, 3);
        lottoStatisticMap.put(LottoRank.FIFTH, 2);
        //lottoStatisticMap.put(LottoRank.MISS, 3);
        LottoStatistic expected = new LottoStatistic(lottoStatisticMap);
        actual.toFormattingStringList().forEach(System.out::println);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("당첨 통계에 2등 추가")
    void makeStatisticAdd2nd() {
        LottoNumber bonusNumber = new LottoNumber(7);
        List<LottoNumber> numbersContainsBonus = Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), bonusNumber
        );
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(numbersContainsBonus, 5),
                new Lotto(numbers, 5),
                new Lotto(numbersContainsBonus, 5)
        );
        Lottos lottos = new Lottos(lottoList);
        LottoStatistic actual = lottos.makeStatistic(bonusNumber);
        SortedMap<LottoRank, Integer> lottoStatisticMap = new TreeMap<>();
        lottoStatisticMap.put(LottoRank.SECOND, 2);
        lottoStatisticMap.put(LottoRank.THIRD, 1);
        LottoStatistic expected = new LottoStatistic(lottoStatisticMap);
        actual.toFormattingStringList().forEach(System.out::println);
        expected.toFormattingStringList().forEach(System.out::println);
        assertThat(actual).isEqualTo(expected);
    }

}
