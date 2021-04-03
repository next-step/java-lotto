package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 46;

    public static void main(String[] args) {
        int lottoPurchaseAmount = InputView.getLottoPurchaseAmount();

        List<Integer> lottoAllNumberInRange = getLottoAllNumberInRange();
        GenerateLotto generateLotto = new GenerateLotto(lottoAllNumberInRange, lottoPurchaseAmount);
        Lottos lottos = new Lottos(generateLotto.getGeneratedLottos());
        ResultView.printLottos(lottos);

        String winnersNumbers = InputView.getWinnersNumber();
        Set<LottoNumber> lottoNumbers = getLottoNumbers(winnersNumbers);
        Lotto winnerLotto = new Lotto(lottoNumbers);
        Map<Integer, Long> matchResults = lottos.getMatchResults(winnerLotto);
        ResultView.printMatchResults(matchResults);

        LottoBenefitCalculator lottoBenefitCalculator =
                new LottoBenefitCalculator(lottoPurchaseAmount, matchResults);
        ResultView.printBenefitResult(lottoBenefitCalculator.resultBenefit());
    }

    private static List<Integer> getLottoAllNumberInRange() {
        return IntStream.range(LOTTO_NUMBER_RANGE_MIN, LOTTO_NUMBER_RANGE_MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    private static Set<LottoNumber> getLottoNumbers(String winnersNumbers) {
        return Arrays.stream(winnersNumbers.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
