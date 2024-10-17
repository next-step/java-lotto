package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMatcher;
import lotto.view.LottoInput;
import lotto.view.LottoPrint;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        gameStart();
    }

    public static void gameStart() {
        LottoInput lottoInput = new LottoInput();

        int purchasedAmount = lottoInput.getPurchasedAmount();
        LottoGenerator lottoGenerator = new LottoGenerator(purchasedAmount);

        List<Lotto> lottoTickets = lottoGenerator.generateLottoTickets();
        System.out.println(lottoTickets.size() +"개를 구매했습니다.");
        lottoTickets.forEach(System.out::println);

        String winningLottoNumbers = lottoInput.getWinningNumbers();
        LottoMatcher matcher = new LottoMatcher(lottoGenerator, winningLottoNumbers);
        List<Integer> matchedLottoList = matcher.matchLottoNumber(lottoTickets);

        LottoPrint lottoPrint = new LottoPrint();
        lottoPrint.lottoResult(matchedLottoList, purchasedAmount);
    }


}
