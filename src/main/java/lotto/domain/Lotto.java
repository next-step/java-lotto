package lotto.domain;

import lotto.enums.Rank;

import java.util.*;

public class Lotto {
    public static final int PRICE = 1000;
    private List<LottoNumbers> lottoNumbers = new ArrayList<>();
    private int manualCount = 0;

    public Lotto() {
    }

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(List<LottoNumbers> lottoNumbers, int manualCount) {
        this.lottoNumbers = lottoNumbers;
        this.manualCount = manualCount;
    }

    public static Lotto sellLotto(long amount, List<List<Integer>> manualNumbersList) {
        validatePurchaseAmount(manualNumbersList, amount / PRICE);
        return new Lotto(addTicktes(manualNumbersList, amount / PRICE), manualNumbersList == null ? 0 : manualNumbersList.size());
    }

    public EnumMap<Rank, Integer> makeStatistics(WinningNumbers winningLottoNumbers) {
        EnumMap<Rank, Integer> countPerPrize = new EnumMap<>(Rank.class);
        initEnumMap(countPerPrize);

        for (LottoNumbers numbers : lottoNumbers) {
            winningLottoNumbers.findRank(numbers).ifPresent(rank -> countPerPrize.put(rank, countPerPrize.get(rank) + 1));
        }

        return countPerPrize;
    }

    public long calcWinningAmount(WinningNumbers winningLottoNumbers) {
        long totalAmount = 0;
        for (Map.Entry<Rank, Integer> entry : this.makeStatistics(winningLottoNumbers).entrySet()) {
            totalAmount += entry.getKey().calcWinningAmountPerRank(entry.getValue());
        }
        return totalAmount;
    }


    public double calcRateOfReturn(WinningNumbers winningLottoNumbers) {
        return (double) this.calcWinningAmount(winningLottoNumbers) / (lottoNumbersCount() * PRICE);
    }

    public int lottoNumbersCount() {
        return this.lottoNumbers.size();
    }

    public int manualCount() {
        return this.manualCount;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    private void initEnumMap(EnumMap<Rank, Integer> countPerPrize) {
        for (Rank rank : Rank.values()) {
            countPerPrize.put(rank, 0);
        }
    }

    private static List<LottoNumbers> addTicktes(List<List<Integer>> manualNumbersList, long availableCount) {
        if (manualNumbersList == null) {
            manualNumbersList = new ArrayList<>();
        }

        List<LottoNumbers> tickets = new ArrayList<>();
        for (List<Integer> numbers : manualNumbersList) {
            tickets.add(new LottoNumbers(numbers));
        }

        for (int i = 0; i < availableCount - manualNumbersList.size(); i++) {
            tickets.add(new LottoNumbers());
        }

        return tickets;
    }

    private static void validatePurchaseAmount(List<List<Integer>> manualNumbersList, long availableCount) {
        if (manualNumbersList != null && availableCount < manualNumbersList.size()) {
            throw new IllegalArgumentException("구매금액을 넘는 로또를 구매할 수 없습니다.");
        }
    }
}
