package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoDetailMatch;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMatcher;
import lotto.view.LottoInput;
import lotto.view.LottoPrint;

import java.util.List;
import java.util.Map;

public class LottoGame {

    public static void main(String[] args) {
        gameStart();
    }

    public static void gameStart() {
        LottoInput lottoInput = new LottoInput();

        int purchasedAmount = lottoInput.getPurchasedAmount();
        LottoGenerator lottoGenerator = new LottoGenerator();

        List<Lotto> lottoTickets = lottoGenerator.generateLottoTickets(purchasedAmount);

        LottoPrint lottoPrint = new LottoPrint();
        lottoPrint.lottoPurchasedCount(lottoTickets);

        String winningLottoNumbers = lottoInput.getWinningNumbers();
        int bonusNumber = lottoInput.getBonusNumber();

        LottoMatcher matcher = new LottoMatcher(lottoGenerator, winningLottoNumbers);

        Map<String, Integer> rankCounts = matcher.matchAndCount(lottoTickets, bonusNumber);
        double profitRate = matcher.calculateProfitRate(rankCounts, purchasedAmount);
        lottoPrint.lottoResult(rankCounts, profitRate);

    }


}
