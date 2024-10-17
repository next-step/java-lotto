package lotto.service;

import lotto.utility.LottoWinningStaticsCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    private final static int lottoPrice = 1000;

    private final LottoSeller lottoSeller;

    public LottoService() {
        lottoSeller = new LottoSeller();
    }

    public int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / lottoPrice;
    }

    public void purchaseLottos(int lottoCount) {
        lottoSeller.sellLottos(lottoCount);
    }

    public Map<Integer, Integer> provideWinningStatics(String lastWeekWinningNumbers, Map<Integer, List<Integer>> lottos) {
        List<Integer> winningNumber = parseWinningNumber(lastWeekWinningNumbers);

        return LottoWinningStaticsCalculator.calculateWinningStatics(winningNumber, lottos);
    }

    private static List<Integer> parseWinningNumber(String lastWeekWinningNumber) {
        return Arrays.stream(lastWeekWinningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public float provideReturnRate(int purchaseAmount, Map<Integer, Integer> statics) {
        return LottoWinningStaticsCalculator.calculateReturnRate(purchaseAmount, statics);
    }

    public Map<Integer, List<Integer>> provideLottos() {
        return lottoSeller.provideLottos();
    }

}
