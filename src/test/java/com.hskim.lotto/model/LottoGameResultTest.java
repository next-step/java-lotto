package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameResultTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        LottoGameResult lottoGameResult = new LottoGameResult();
        LottoGameResult expected = new LottoGameResult();
        List<LottoWinTable> winTables = Arrays.asList(LottoWinTable.SECOND_PLACE, LottoWinTable.FOURTH_PLACE);
        int totalTicketPrice = 14000;

        // when
        lottoGameResult.putWinnerStatisticsData(winTables);
        lottoGameResult.calculateEarningRate(totalTicketPrice);
        expected.putWinnerStatisticsData(winTables);
        expected.calculateEarningRate(totalTicketPrice);

        // then
        assertThat(lottoGameResult).isEqualTo(expected);
    }
}
