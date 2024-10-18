package lotto.domain;

import java.math.BigDecimal;

import java.math.RoundingMode;

import lotto.vo.Winning;
import lotto.vo.WinningResult;
import lotto.enumeration.Rank;
import lotto.strategy.LottoGenerator;

import java.util.*;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;
    public static final int TWO_DECIMAL_PLACE = 2;
    public static final int DEFAULT_RANK_COUNT = 0;

    private final LottoGenerator lottoGenerator;

    public LottoGame(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> create(final String money) {
        int count = Integer.parseInt(money) / LOTTO_PRICE;
        return lottoGenerator.generate(count);
    }

    public WinningResult match(final List<Lotto> lottos, final InputNumber inputNumber) {
        Map<Rank, Integer> rankCountMap = rankCountMap(lottos, inputNumber);
        List<Winning> winnings = winnings(rankCountMap);
        BigDecimal totalReturn = totalReturn(lottos, winnings);
        return new WinningResult(winnings, totalReturn);
    }

    private static Map<Rank, Integer> rankCountMap(List<Lotto> lottos, InputNumber inputNumber) {
        Map<Rank, Integer> rankCountMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.rank(inputNumber);
            int count = rankCountMap.getOrDefault(rank, DEFAULT_RANK_COUNT) + 1;
            rankCountMap.put(rank, count);
        }
        return rankCountMap;
    }

    private static List<Winning> winnings(Map<Rank, Integer> rankCountMap) {
        List<Winning> list = new ArrayList<>();
        for (Rank rank : Rank.values()) {
            list.add(new Winning(rank, rankCountMap.getOrDefault(rank, DEFAULT_RANK_COUNT)));
        }
        return list;
    }

    private static BigDecimal totalReturn(List<Lotto> lottos, final List<Winning> rankCountMap) {
        BigDecimal buyPrice = new BigDecimal(lottos.size() * LOTTO_PRICE);
        BigDecimal sumWinningPrice = new BigDecimal(
                rankCountMap.stream()
                        .mapToInt(it -> it.getRank().getPrice() * it.getCountWinning())
                        .sum());
        return sumWinningPrice.divide(buyPrice, TWO_DECIMAL_PLACE, RoundingMode.DOWN);
    }
}
