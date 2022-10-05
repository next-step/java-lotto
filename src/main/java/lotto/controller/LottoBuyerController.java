package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.MatchingResult;
import lotto.strategy.RandomNumberGenerateStrategy;

import java.util.List;

public class LottoBuyerController {

    private LottoBuyer lottoBuyer;

    public LottoBuyerController(LottoBuyer lottoBuyer) {
        this.lottoBuyer = lottoBuyer;
    }

    public void buyLotto(int money){
        lottoBuyer.buy(money);
        lottoBuyer.generateNumbers(new RandomNumberGenerateStrategy());
    }

    public List<Lotto> getLotties(){
        return lottoBuyer.getMyLotto();
    }

    public List<MatchingResult> matchingResults(List<Integer> answer){
        return lottoBuyer.matchingResults(answer);
    }

}
