package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class LottoMachineTest {

    @Test
    public void test_purchase() {
        final int purchaseWon = 15000;

        LottoList lottoList = LottoMachine.purchase(purchaseWon);

        assertThat(lottoList.size()).isEqualTo(15);
    }

    @Test(expected = RuntimeException.class)
    public void test_purchase_음수() {
        final int purchaseWon = -10000;

        LottoList lottoList = LottoMachine.purchase(purchaseWon);
    }

    @Test
    public void test_purchase_원단위_절삭() {
        final int purchaseWon = 14500;

        LottoList lottoList = LottoMachine.purchase(purchaseWon);

        assertThat(lottoList.size()).isEqualTo(14);
    }


    @Test
    public void getWinningResult() {
        final Lotto anyLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        final WinningLotto winningLotto = new WinningLotto(anyLotto);

        final LottoList lottos = new LottoList(Arrays.asList(
                anyLotto, // 6개 일치
                new Lotto(Arrays.asList( // 4개 일치
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(44), new LottoNumber(45))),
                new Lotto(Arrays.asList( // 4개 일치
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(44), new LottoNumber(45))),
                new Lotto(Arrays.asList( // 3개 일치
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)))));

        final WinningResults winningResults = LottoMachine.getWinningResults(lottos, winningLotto);

        Map<Prize, WinningResult> expectedWinningResults = new HashMap<>();
        expectedWinningResults.put(Prize.FOURTH, new WinningResult(Prize.FOURTH, 1));
        expectedWinningResults.put(Prize.THIRD, new WinningResult(Prize.THIRD, 2));
        expectedWinningResults.put(Prize.SECOND, new WinningResult(Prize.SECOND, 0));
        expectedWinningResults.put(Prize.FIRST, new WinningResult(Prize.FIRST, 1));

        for (Prize prize : Prize.values()) {
            assertThat(winningResults.get(prize).getMatchCount())
                .isEqualTo(expectedWinningResults.get(prize).getMatchCount());
        }

    }

    @Test
    public void getEarningsRate() {

        final long purchaseAmount = 4000;

        final Lotto anyLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        final WinningLotto winningLotto = new WinningLotto(anyLotto);

        final LottoList lottos = new LottoList(Arrays.asList(
                anyLotto,
                new Lotto(Arrays.asList(
                        new LottoNumber(21), new LottoNumber(22), new LottoNumber(23),
                        new LottoNumber(24), new LottoNumber(25), new LottoNumber(26))),
                new Lotto(Arrays.asList(
                        new LottoNumber(31), new LottoNumber(32), new LottoNumber(33),
                        new LottoNumber(34), new LottoNumber(35), new LottoNumber(36))),
                new Lotto(Arrays.asList(
                        new LottoNumber(40), new LottoNumber(41), new LottoNumber(42),
                        new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)))));

        WinningResults lottoResults = LottoMachine.getWinningResults(lottos, winningLotto);

        assertThat(LottoMachine.getEarningsRate(lottoResults, purchaseAmount))
            .isEqualTo(Prize.FIRST.getMoney() / (double) purchaseAmount);
    }
}