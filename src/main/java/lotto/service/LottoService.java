package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private static final int LOTTO_PRICE = 1000;

    public LottoService() {
    }

    public int canBuyLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    public List<Integer> buyLotto() {
        return LottoSeller.sellLotto();
    }

    public int[] provideWinningStatics(String lastWeekWinningNumbers, List<Integer>[] lotto) {
        List<Integer> winningNumber = parseWinningNumber(lastWeekWinningNumbers);

        return LottoWinningStaticsCalculator.calculateWinningStatics(winningNumber, lotto);
    }

    private List<Integer> parseWinningNumber(String lastWeekWinningNumber) {
        return Arrays.stream(lastWeekWinningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public float provideReturnRate(int purchaseAmount, int[] winningStatics) {
        return LottoWinningStaticsCalculator.calculateReturnRate(purchaseAmount, winningStatics);
    }

}
