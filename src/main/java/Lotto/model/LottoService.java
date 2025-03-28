package Lotto.model;

import Lotto.model.NumberExtractor.NumberExtractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final int NUMBER_SIZE = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int SALES_PRICE = 1000;
    private final NumberExtractor extractor;
    private final int purchaseAmount;
    private final int lottoNum;
    private Map<Integer, Integer> winningCountMap;
    private List<Lotto> lottos;

    public LottoService(int purchaseAmount, NumberExtractor extractor) {
        this.purchaseAmount = purchaseAmount;
        this.lottoNum = purchaseAmount / SALES_PRICE;
        this.extractor = extractor;
    }

    public void draw() {
        this.lottos = new ArrayList<>();

        for (int i = 0; i < lottoNum; i++) {
            Lotto lotto = new Lotto(extractor);
            lotto.draw(NUMBER_SIZE, MIN_NUM, MAX_NUM);
            lottos.add(lotto);
        }
    }

    public List<List<Integer>> lottoList() {
        List<List<Integer>> lottoList = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoList.add(lotto.numbers());
        }

        return lottoList;
    }

    public int lottoNum() {
        return this.lottoNum;
    }

    public void decideWinning(int[] winnerNum) {
        this.winningCountMap = new HashMap<>(Map.of(
                LottoPrizeTable.MATCHED_3, 0,
                LottoPrizeTable.MATCHED_4, 0,
                LottoPrizeTable.MATCHED_5, 0,
                LottoPrizeTable.MATCHED_6, 0
        ));

        for (Lotto lotto : lottos) {
            int matchedNum = lotto.checkMatched(winnerNum);
            increaseWinningCount(matchedNum);
        }
    }

    private void increaseWinningCount(int matchedNum) {
        if (winningCountMap.containsKey(matchedNum)){
            winningCountMap.put(matchedNum, winningCountMap.get(matchedNum) + 1);
        }
    }

    public int[] winningCounts() {
        return winningCountMap.values().stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public double profitRate() {
        double sum = 0;
        for (Map.Entry<Integer, Integer> entry : winningCountMap.entrySet()){
            sum += LottoPrizeTable.prize(entry.getKey()) * entry.getValue();
        }

        return sum / purchaseAmount;
    }
}
