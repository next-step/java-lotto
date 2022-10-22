package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.MatchingResult;
import lotto.domain.WinningNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {


    public static List<MatchingResult> getMatchingResults(List<Lotto> lotties, WinningNumber winningNumber) {
        return lotties.stream()
                .map(lotto -> winningNumber.results(lotto.getLottoNumbers()))
                .collect(Collectors.toList());
    }

}
