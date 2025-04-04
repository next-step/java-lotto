package Lotto.model;

import Lotto.model.NumberExtractor.NumberExtractor;

import java.util.*;

public class LottoService {
    private static final int NUMBER_SIZE = 6;
    static final int SALES_PRICE = 1000;
    private final NumberExtractor extractor;
    private final PurchaseAmount purchaseAmount;
    private final int lottoNum;
    private final Map<LottoRank, Integer> winningCountMap = new EnumMap<>(LottoRank.class);
    private Lottos lottos;

    public LottoService(int purchaseAmount, NumberExtractor extractor) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        this.lottoNum = purchaseAmount / SALES_PRICE;
        this.extractor = extractor;
    }

    public void draw() {
        this.lottos = new Lottos();

        for (int i = 0; i < lottoNum; i++) {
            Lotto lotto = new Lotto(extractor);
            lotto.draw();
            lottos.add(lotto);
        }
    }

    public List<List<Integer>> lottoList(){
        return lottos.toIntegerNumberList();
    }

    public int lottoNum() {
        return this.lottoNum;
    }

    private void validateLottoNumber(List<Integer> lottoNumber) {
        if (lottoNumber.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("The count of Lotto number exceed 6.");
        }

        Set<Integer> set = new HashSet<>(lottoNumber);
        if (set.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("Lotto numbers must not contain duplicates.");
        }
    }

    public void decideWinning(List<Integer> winnerNum) {
        validateLottoNumber(winnerNum);
        for (LottoRank rank : LottoRank.values()) {
            winningCountMap.put(rank, 0);
        }

        for (Lotto lotto : lottos.all()) {
            int matchedNum = lotto.checkMatched(winnerNum);
            increaseWinningCount(LottoRank.valueOf(matchedNum));
        }
    }

    private void increaseWinningCount(LottoRank rank) {
        winningCountMap.put(rank, winningCountMap.getOrDefault(rank, 0) + 1);
    }

    public Map<LottoRank, Integer> winningCountMap() {
        return Collections.unmodifiableMap(new EnumMap<>(this.winningCountMap));
    }

    public double profitRate() {
        double sum = 0;
        for (Map.Entry<LottoRank, Integer> entry : winningCountMap.entrySet()) {
            sum += entry.getKey().getWinningMoney() * entry.getValue();
        }

        return sum / purchaseAmount.value();
    }
}
