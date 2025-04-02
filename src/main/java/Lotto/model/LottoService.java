package Lotto.model;

import Lotto.model.NumberExtractor.NumberExtractor;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {
    private static final int SALES_PRICE = 1000;
    private final NumberExtractor extractor;
    private final int purchaseAmount;
    private final int lottoNum;
    private final Map<LottoRank, Integer> winningCountMap = new EnumMap<>(LottoRank.class);
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

    private void validateLottoNumber(List<Integer> lottoNumber) {
        if (lottoNumber.size() != 6) {
            throw new IllegalArgumentException("The count of Lotto number exceed 6.");
        }

        Set<Integer> set = new HashSet<>();
        for (int num : lottoNumber) {
            if (!set.add(num)) {
                throw new IllegalArgumentException("Lotto numbers must not contain duplicates.");
            }
        }
    }

    public void decideWinning(List<Integer> winnerNum) {
        validateLottoNumber(winnerNum);
        for (LottoRank rank : LottoRank.values()){
            winningCountMap.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchedNum = lotto.checkMatched(winnerNum);
            increaseWinningCount(LottoRank.valueOf(matchedNum));
        }
    }

    private void increaseWinningCount(LottoRank rank) {
        winningCountMap.put(rank, winningCountMap.getOrDefault(rank, 0) + 1);
    }

    public List<Integer> winningCounts() {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .map(rank -> winningCountMap.getOrDefault(rank, 0))
                .collect(Collectors.toList());
    }

    public double profitRate() {
        double sum = 0;
        for (Map.Entry<LottoRank, Integer> entry : winningCountMap.entrySet()) {
            sum += entry.getKey().getWinningMoney() * entry.getValue();
        }

        return sum / purchaseAmount;
    }
}
