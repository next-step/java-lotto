package service;

import generator.RandomNumberGenerator;
import model.Lotto;
import model.LottoResult;
import model.LottoShop;
import model.Rank;
import ui.InputView;
import ui.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    public void play () {
        int payAmount = InputView.getPayAmount();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoShop lottoShop = new LottoShop(randomNumberGenerator);
        List<Lotto> paidLottoList = lottoShop.generateLotto(payAmount);
        for(Lotto lotto : paidLottoList) {
            System.out.println(lotto.toString());
        }

        Lotto winningLotto = InputView.getLastWeekWinNumber();
        Map<Rank, Integer> totalRank = new HashMap<>();
        for(Lotto paidLotto: paidLottoList) {
            int count = paidLotto.countWinningNumbers(winningLotto);
            Rank rank = Rank.of(count);
            totalRank.put(rank, totalRank.getOrDefault(rank, 0) + 1);
        }
        ResultView.getResult(payAmount, new LottoResult(totalRank));
    }

}
