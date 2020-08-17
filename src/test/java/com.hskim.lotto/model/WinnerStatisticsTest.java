package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerStatisticsTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        WinnerStatistics winnerStatistics = new WinnerStatistics();

        // when & then
        assertThat(winnerStatistics).isEqualTo(new WinnerStatistics());
    }

    @DisplayName("putData() 동치성 테스트")
    @Test
    void putData_동치성_테스트() {
        // given
        WinnerStatistics winnerStatistics = new WinnerStatistics();
        winnerStatistics.putData(Collections.singletonList(LottoWinTable.FIRST_PLACE));

        WinnerStatistics sameStatistic = new WinnerStatistics();
        sameStatistic.putData(Collections.singletonList(LottoWinTable.FIRST_PLACE));

        WinnerStatistics diffStatistic = new WinnerStatistics();
        diffStatistic.putData(Collections.singletonList(LottoWinTable.SECOND_PLACE));

        // when & then
        assertThat(winnerStatistics).isEqualTo(sameStatistic);
        assertThat(winnerStatistics).isNotEqualTo(diffStatistic);
    }

    @DisplayName("putData() 여러개 동작 테스트")
    @Test
    void putData_여러개_동작() {
        // given
        WinnerStatistics winnerStatistics = new WinnerStatistics();
        winnerStatistics.putData(Arrays.asList(LottoWinTable.FIRST_PLACE, LottoWinTable.FIRST_PLACE));

        Map<LottoWinTable, Integer> winnerMap = new HashMap<>();
        winnerMap.put(LottoWinTable.FIRST_PLACE, 2);
        WinnerStatistics sameStatistic = new WinnerStatistics(winnerMap);

        // when & then
        assertThat(winnerStatistics).isEqualTo(sameStatistic);
    }
}
