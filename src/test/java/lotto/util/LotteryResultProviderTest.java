package lotto.util;

import lotto.model.Lotteries;
import lotto.model.Lottery;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryResultProviderTest {

    @Test
    void getThreeCorrectResult() {
        List<Lottery> lotteryList = new ArrayList<>();
        lotteryList.add(new Lottery(Arrays.asList(1, 4, 5, 6, 20, 45))); // 5개 적중
        lotteryList.add(new Lottery(Arrays.asList(5, 20, 21, 35, 40, 41))); // 2개 적중
        lotteryList.add(new Lottery(Arrays.asList(6, 7, 20, 25, 30, 37))); // 3개 적중
        lotteryList.add(new Lottery(Arrays.asList(1, 2, 5, 6, 20, 21))); // 4개 적중
        lotteryList.add(new Lottery(Arrays.asList(1, 2, 5, 6, 20, 21))); // 4개 적중
        lotteryList.add(new Lottery(Arrays.asList(1, 2, 5, 6, 20, 21))); // 4개 적중
        lotteryList.add(new Lottery(Arrays.asList(1, 2, 5, 6, 20, 21))); // 4개 적중

        List<Integer> winningNumbers = Arrays.asList(1, 4, 5, 6, 20, 25);

        Lotteries lotteires = new Lotteries(lotteryList);
        assertThat(LottoResultProvider.getResult(lotteires, winningNumbers).getWinningCount3()).isEqualTo(1);
        assertThat(LottoResultProvider.getResult(lotteires, winningNumbers).getWinningCount4()).isEqualTo(4);
        assertThat(LottoResultProvider.getResult(lotteires, winningNumbers).getWinningCount5()).isEqualTo(1);
        assertThat(LottoResultProvider.getResult(lotteires, winningNumbers).getWinningCount6()).isEqualTo(0);
    }
}