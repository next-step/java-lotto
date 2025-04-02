package Lotto.model;

import Lotto.model.NumberExtractor.NumberExtractor;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    private static final int SALES_PRICE = 1000;
    private final NumberExtractor extractor;
    private final int purchaseAmount;
    private final int lottoNum;
    private Map<Integer, Integer> winningCountMap;
    private List<Lotto> lottos;

    public LottoService(int purchaseAmount, NumberExtractor extractor) {
        this.validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottoNum = purchaseAmount / SALES_PRICE;
        this.extractor = extractor;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("The minimum of purchase price is 1,000 won.");
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("The purchase price is in units of 1,000 won.");
        }
    }

    public void draw() {
        this.lottos = new ArrayList<>();

        for (int i = 0; i < lottoNum; i++) {
            Lotto lotto = new Lotto(extractor);
            lotto.draw();
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

    private void validateLottoNumber(List<Integer> lottoNumber){
        if (lottoNumber.size() != 6){
            throw new IllegalArgumentException("The count of Lotto number exceed 6.");
        }

        Set<Integer> set = new HashSet<>();
        for (int num: lottoNumber){
            if (!set.add(num)){
                throw new IllegalArgumentException("Lotto numbers must not contain duplicates.");
            }
        }
    }

    public void decideWinning(List<Integer> winnerNum) {
        validateLottoNumber(winnerNum);
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
        if (winningCountMap.containsKey(matchedNum)) {
            winningCountMap.put(matchedNum, winningCountMap.get(matchedNum) + 1);
        }
    }

    public List<Integer> winningCounts() {
        return new ArrayList<>(winningCountMap.values());
    }

    public double profitRate() {
        double sum = 0;
        for (Map.Entry<Integer, Integer> entry : winningCountMap.entrySet()) {
            sum += LottoPrizeTable.prize(entry.getKey()) * entry.getValue();
        }

        return sum / purchaseAmount;
    }
}
