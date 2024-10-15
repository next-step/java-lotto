package lotto.controller;

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

        int purchaseCount = lottoGenerator.purchase();
        System.out.println(purchaseCount +"개를 구매했습니다.");

        List<List<Integer>> lottoPurchaseAmounts = lottoGenerator.chooseLottoNumber(purchaseCount);
        lottoPurchaseAmounts.forEach(System.out::println);

        String winningLottoNumbers = lottoInput.getWinningNumbers();
        LottoMatcher matcher = new LottoMatcher(lottoGenerator, winningLottoNumbers);
        List<Integer> matchedLottoList = matcher.matchLottoNumber(lottoPurchaseAmounts);

        LottoPrint lottoPrint = new LottoPrint();
        lottoPrint.lottoResult(matchedLottoList, purchasedAmount);
    }


}
