package Lotto.model;

import Lotto.model.NumberExtractor.NumberExtractor;

import java.util.*;

public class LottoService {
    private static final int NUMBER_SIZE = 6;
    static final int SALES_PRICE = 1000;
    private final NumberExtractor autoExtractor;
    private final NumberExtractor[] manualExtractors;
    private final PurchaseAmount purchaseAmount;
    private final int manualLottoNum;
    private final int autoLottoNum;
    private final Map<LottoRank, Integer> winningCountMap = new EnumMap<>(LottoRank.class);
    private Lottos lottos;

    public LottoService(int purchaseAmount, NumberExtractor autoExtractor) {
        this(purchaseAmount, autoExtractor, new NumberExtractor[0]);
    }

    public LottoService(int purchaseAmount, NumberExtractor autoExtractor, NumberExtractor... manualExtractors) {
        int autoPurchaseAmount = purchaseAmount - (manualExtractors.length * SALES_PRICE);

        this.autoLottoNum = autoPurchaseAmount / SALES_PRICE;
        this.manualLottoNum = manualExtractors.length;
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        this.autoExtractor = autoExtractor;
        this.manualExtractors = manualExtractors;
        this.lottos = new Lottos();
    }

    public void draw() {
        this.lottos = new Lottos();
        drawManually();
        drawAutomatically();
    }

    private void drawManually(){
        for (NumberExtractor extractor: manualExtractors){
            Lotto lotto = new Lotto(extractor);
            lotto.draw();
            lottos.add(lotto);
        }
    }

    private void drawAutomatically(){
        for (int i = 0; i < autoLottoNum; i++) {
            Lotto lotto = new Lotto(autoExtractor);
            lotto.draw();
            lottos.add(lotto);
        }
    }

    public List<List<Integer>> lottoList() {
        return lottos.toIntegerNumberList();
    }

    public int lottoNum() {
        return this.autoLottoNum + this.manualLottoNum;
    }

    public int autoLottoNum(){
        return this.autoLottoNum;
    }

    public int manualLottoNum(){
        return this.manualLottoNum;
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

    public void decideWinning(List<Integer> winnerNum, int bonusNumber) {
        validateLottoNumber(winnerNum);
        WinningNumber winningNumber = new WinningNumber(winnerNum, bonusNumber);
        for (LottoRank rank : LottoRank.values()) {
            winningCountMap.put(rank, 0);
        }

        for (Lotto lotto : lottos.all()) {
            int matchedCount = winningNumber.countMatchedNumber(lotto);
            increaseWinningCount(LottoRank.valueOf(matchedCount, winningNumber.matchedBonusNumber(lotto)));
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
