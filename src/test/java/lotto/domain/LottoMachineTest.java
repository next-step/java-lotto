package lotto.domain;


import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

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
        final Lotto winningLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        final LottoList lottos = new LottoList(Arrays.asList(
                winningLotto,
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(44), new LottoNumber(45))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(44), new LottoNumber(45))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)))));

        Map<Prize, LottoList> lottoResult = LottoMachine.getWinningResult(lottos, winningLotto);

        assertThat(lottoResult.get(Prize.FOURTH).size()).isEqualTo(1);
        assertThat(lottoResult.get(Prize.THIRD).size()).isEqualTo(2);
        assertThat(lottoResult.get(Prize.SECOND).size()).isEqualTo(0);
        assertThat(lottoResult.get(Prize.FIRST).size()).isEqualTo(1);
    }

    @Test
    public void getEarningsRate() {
        final long purchaseAmount = 4000;
        final Lotto winningLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        final LottoList lottos = new LottoList(Arrays.asList(
                winningLotto,
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(44), new LottoNumber(45))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(44), new LottoNumber(45))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)))));

        Map<Prize, LottoList> lottoResult = LottoMachine.getWinningResult(lottos, winningLotto);

        long totalPrizeMoney = 0;

        for (Prize prize : Prize.values()) {
            totalPrizeMoney += lottoResult.get(prize).size() * prize.getMoney();
        }

        assertThat(LottoMachine.getEarningsRate(lottoResult, purchaseAmount)).isEqualTo((double) totalPrizeMoney / purchaseAmount);
    }

    @Test
    public void getEarningsRate_10개구매_3개일치_1개() {
        final long purchaseAmount = 10000;

        final Lotto winningLotto = new Lotto(Arrays.asList(
                new LottoNumber(45), new LottoNumber(44), new LottoNumber(43),
                new LottoNumber(42), new LottoNumber(41), new LottoNumber(40)));

        final LottoList lottos = new LottoList(Arrays.asList(
                winningLotto,
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new Lotto(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))));

        Map<Prize, LottoList> lottoResult = LottoMachine.getWinningResult(lottos, winningLotto);

        long totalPrizeMoney = 0;
        for (Prize prize : Prize.values()) {
            totalPrizeMoney += lottoResult.get(prize).size() * prize.getMoney();
        }

        double result = LottoMachine.getEarningsRate(lottoResult, purchaseAmount);

        assertThat(result).isEqualTo((double) totalPrizeMoney / purchaseAmount);
    }
}