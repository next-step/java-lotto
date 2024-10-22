package lotto.service;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoBuyer {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public LottoBuyer() {
        lottos = new ArrayList<>();
    }

    public int canBuyLottoCount(int buyAmount) {
        return buyAmount / LOTTO_PRICE;
    }

    public List<Integer> buyLotto(List<Integer> lottoNumber) {
        this.lottos.add(new Lotto(lottoNumber));

        return lottoNumber;
    }

    public Map<Integer, Integer> checkLottoResult(String lastWeekWinningNumbers, int bonusNumber) {
        List<Integer> winningNumber = parseWinningNumber(lastWeekWinningNumbers);

        return LottoAnalyzer.calculateWinningStatics(winningNumber, bonusNumber, lottos);
    }

    public float checkReturnRate(int buyAmount, Map<Integer, Integer> winningStatics) {
        return LottoAnalyzer.calculateReturnRate(buyAmount, winningStatics);
    }

    private List<Integer> parseWinningNumber(String lastWeekWinningNumber) {
        return Arrays.stream(lastWeekWinningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
