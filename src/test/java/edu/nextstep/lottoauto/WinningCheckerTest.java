/*
 * WinningCheckerTest.java
 *
 * v0.1 ,  2021.08.14
 */

package edu.nextstep.lottoauto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningCheckerTest {

    @Test
    void create() {
        // given
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};

        // when
        WinningChecker winningChecker = WinningChecker.createOf(winningNumbers);

        // then
        Assertions.assertThat(winningChecker.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void winningCheck() {
        // given
        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.add(LottoTicket.create(new int[]{1, 2, 3, 4, 5, 6}));
        lottoTickets.add(LottoTicket.create(new int[]{2, 3, 4, 5, 6, 7}));
        lottoTickets.add(LottoTicket.create(new int[]{3, 4, 5, 6, 7, 8}));
        lottoTickets.add(LottoTicket.create(new int[]{4, 5, 6, 7, 8, 9}));


        // when
        WinningChecker winningChecker = WinningChecker.createOf(new int[]{1, 2, 3, 4, 5, 6});
        Map<WinningPrize, Integer> winningCheckResult = winningChecker.winningCheck(lottoTickets);
        Map<WinningPrize, Integer> checkResult = new HashMap<>();
        checkResult.put(WinningPrize.THREE, 1);
        checkResult.put(WinningPrize.FOUR, 1);
        checkResult.put(WinningPrize.FIVE, 1);
        checkResult.put(WinningPrize.SIX, 1);

        // then
        Assertions.assertThat(winningCheckResult).isEqualTo(checkResult);
    }
}
