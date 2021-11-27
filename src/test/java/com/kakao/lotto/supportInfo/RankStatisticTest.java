package com.kakao.lotto.supportInfo;

import com.kakao.lotto.domain.LottoRank;
import com.kakao.lotto.domain.LottoTicket;
import com.kakao.lotto.domain.LottoTickets;
import com.kakao.lotto.domain.WinLottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankStatisticTest {

    @ParameterizedTest
    @MethodSource("lottoMatchWinNumber")
    @DisplayName("LottoTickets에 담긴 티켓들의 등수를 맞춰보는 RankStatistic을 생성한다.")
    void createRankStatistic(LottoRank correctLottoRank, LottoTicket lottoTicket) {
        LottoTickets lottoTickets = new LottoTickets(Collections.singletonList(lottoTicket));
        WinLottoTicket winLottoTicket = WinLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        RankStatistic rankStatistic = lottoTickets.createRankStatistic(winLottoTicket, 1000);
        rankStatistic.getRankCount()
                .forEach((key, value) -> assertThat(value).isEqualTo(getResult(correctLottoRank, key)));
    }

    private int getResult(LottoRank correctLottoRank, LottoRank checkRank) {
        return checkRank == correctLottoRank ? 1 : 0;
    }

    private static Stream<Arguments> lottoMatchWinNumber() {
        return Stream.of(
                Arguments.arguments(LottoRank.FIRST, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.arguments(LottoRank.SECOND, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7))),
                Arguments.arguments(LottoRank.THIRD, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 45))),
                Arguments.arguments(LottoRank.FOURTH, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 44, 45))),
                Arguments.arguments(LottoRank.FIFTH, LottoTicket.of(Arrays.asList(1, 2, 3, 43, 44, 45))),
                Arguments.arguments(LottoRank.OUT, LottoTicket.of(Arrays.asList(1, 2, 42, 43, 44, 45))),
                Arguments.arguments(LottoRank.OUT, LottoTicket.of(Arrays.asList(1, 41, 42, 43, 44, 45))),
                Arguments.arguments(LottoRank.OUT, LottoTicket.of(Arrays.asList(40, 41, 42, 43, 44, 45)))
        );
    }

    @ParameterizedTest
    @MethodSource("lottoMatchWinNumberProfit")
    @DisplayName("LottoTickets에 담긴 티켓들의 이익률을 확인할 수 있는 RankStatistic을 생성한다.")
    void createRankStatisticProfit(double profit, LottoTicket lottoTicket) {
        LottoTickets lottoTickets = new LottoTickets(Collections.singletonList(lottoTicket));
        WinLottoTicket winLottoTicket = WinLottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        RankStatistic rankStatistic = lottoTickets.createRankStatistic(winLottoTicket, 1000);
        assertThat(rankStatistic.getProfit()).isEqualTo(profit);
    }

    private static Stream<Arguments> lottoMatchWinNumberProfit() {
        return Stream.of(
                Arguments.arguments(2000000.0, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.arguments(30000.0, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7))),
                Arguments.arguments(1500.0, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 45))),
                Arguments.arguments(50.0, LottoTicket.of(Arrays.asList(1, 2, 3, 4, 44, 45))),
                Arguments.arguments(5.0, LottoTicket.of(Arrays.asList(1, 2, 3, 43, 44, 45))),
                Arguments.arguments(0, LottoTicket.of(Arrays.asList(1, 2, 42, 43, 44, 45))),
                Arguments.arguments(0, LottoTicket.of(Arrays.asList(1, 41, 42, 43, 44, 45))),
                Arguments.arguments(0, LottoTicket.of(Arrays.asList(40, 41, 42, 43, 44, 45)))
        );
    }
}
