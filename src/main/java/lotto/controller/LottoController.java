package lotto.controller;

import lotto.domain.*;
import lotto.strategy.RandomNumberGenerateStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    public static List<Lotto> buy(int money){
        int lottoCount = LottoMachine.lottoTryCount(money);
        return IntStream.range(0, lottoCount)
                .mapToObj(range -> LottoMachine.createLotto(new RandomNumberGenerateStrategy()))
                .collect(Collectors.toList());
    }

    public static List<MatchingResult> getMatchingResults(List<Lotto> lotties, WinningNumber winningNumber) {
        return lotties.stream()
                .map(lotto -> winningNumber.results(lotto.getLottoNumbers()))
                .collect(Collectors.toList());
    }
}
