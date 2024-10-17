package lotto.domain;

import java.math.BigDecimal;

import java.math.RoundingMode;

import lotto.vo.Winning;
import lotto.vo.WinningResult;
import lotto.enumeration.Rank;
import lotto.strategy.LottoGenerator;

import java.util.*;

public class LottoGame {
    public static final int THREE_MATCH = 3;
    public static final int SIX_MATCH = 6;
    public static final int LOTTO_PRICE = 1000;
    public static final int TWO_DECIMAL_PLACE = 2;
    public static final int DEFAULT_COUNT_WINNING = 0;

    private final LottoGenerator lottoGenerator;

    public LottoGame(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> create(final String money) {
        int count = Integer.parseInt(money) / LOTTO_PRICE;
        return lottoGenerator.generate(count);
    }


    public WinningResult match(final List<Lotto> lottos, final String winningNumber) {
        List<Number> winningNumbers = Number.createWinningNumbers(winningNumber);
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            int sumMatchCount = lotto.sumMatchCount(winningNumbers);
            matchCountMap.put(sumMatchCount, matchCountMap.getOrDefault(sumMatchCount, 0) + 1);
        }
        return winningResult(lottos, matchCountMap);
    }

    private static WinningResult winningResult(List<Lotto> lottos, Map<Integer, Integer> rankCountMap) {
        BigDecimal buyPrice = new BigDecimal(lottos.size() * LOTTO_PRICE);
        int winningPrice = 0;
        List<Winning> list = new ArrayList<>();
        for (int countMatch = THREE_MATCH; countMatch <= SIX_MATCH; countMatch++) {
            Rank rank = Rank.rank(countMatch);
            int countWinning = rankCountMap.getOrDefault(countMatch, DEFAULT_COUNT_WINNING);
            list.add(new Winning(countMatch, countWinning));
            winningPrice += rank.getPrice() * countWinning;
        }
        BigDecimal totalWinningPrice = new BigDecimal(winningPrice);
        BigDecimal divide = totalWinningPrice.divide(buyPrice, TWO_DECIMAL_PLACE, RoundingMode.DOWN);
        return new WinningResult(list, divide);
    }
}
