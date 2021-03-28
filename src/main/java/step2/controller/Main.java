package step2.controller;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        int lottoPurchaseAmount = InputView.getLottoPurchaseAmount();
        Market market = new Market(lottoPurchaseAmount, Collections.EMPTY_LIST);
        Lottos lottos = market.getLottos();

        ResultView.printLottos(lottos);

        String winnersNumbers = InputView.getWinnersNumber();
        List<Integer> lottoWinnerNumbers = Arrays.stream(winnersNumbers.split(","))
                .map(winnersNumber -> Integer.parseInt(winnersNumber))
                .collect(Collectors.toList());

        LottoNumberGenerator lottoNumberGenerator = new LottoFixedLottoNumberGenerator(lottoWinnerNumbers);
        Map<Integer, Long> matchResults = lottos.getMatchResults(new Lotto(lottoNumberGenerator));
        LottoMatchResult lottoMatchResult = new LottoMatchResult(lottoPurchaseAmount, matchResults);

        ResultView.printMatchResults(lottoMatchResult);
    }
}
