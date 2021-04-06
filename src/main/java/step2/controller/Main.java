package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        int lottoPurchaseAmount = InputView.getLottoPurchaseAmount();

        List<Integer> lottoAllNumberInRange = NumberGeneration.getLottoAllNumberInRange();
        LottoGeneration lottoGeneration = new LottoGeneration(lottoAllNumberInRange, lottoPurchaseAmount);
        Lottos lottos = new Lottos(lottoGeneration.getGeneratedLottos());
        ResultView.printLottos(lottos);

        String winnersNumbers = InputView.getWinnersNumber();
        Set<LottoNumber> lottoNumbers = SplitNumber.getLottoNumbers(winnersNumbers);
        Lotto winnerLotto = new Lotto(lottoNumbers);
        Map<Integer, Long> matchResults = lottos.getMatchResults(winnerLotto);
        ResultView.printMatchResults(matchResults);

        LottoBenefit lottoBenefitCalculator =
                new LottoBenefit(lottoPurchaseAmount, matchResults);
        ResultView.printBenefitResult(lottoBenefitCalculator.resultBenefit());
    }
}
