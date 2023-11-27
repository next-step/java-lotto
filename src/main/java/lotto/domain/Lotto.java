package lotto.domain;

import lotto.enums.Rank;

import java.util.*;

public class Lotto {
    public static final int PRICE = 1000;
    private List<LottoNumbers> lottoNumbers = new ArrayList<>();

    public Lotto() {
    }

    public Lotto(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void sellLotto(long amount, List<List<Integer>> manualNumbersList) {
        if (manualNumbersList == null) {
            manualNumbersList = new ArrayList<>();
        }
        validatePurchaseAmount(amount, (long) manualNumbersList.size() * PRICE);

        for (List<Integer> numbers : manualNumbersList) {
            addLottoNumbers(numbers);
            amount -= PRICE;
        }

        while (amount >= PRICE) {
            addLottoNumbers();
            amount -= PRICE;
        }
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


    public List<LottoNumbers> getLottoNumbers() {
        return Collections.unmodifiableList(this.lottoNumbers);
    }

    private void initEnumMap(EnumMap<Rank, Integer> countPerPrize) {
        for (Rank rank : Rank.values()) {
            countPerPrize.put(rank, 0);
        }
    }

    private void validatePurchaseAmount(long amount, long requiredAmount) {
        if (amount < requiredAmount) {
            throw new IllegalArgumentException("구매금액을 넘는 로또를 구매할 수 없습니다.");
        }
    }

    private void addLottoNumbers() {
        this.lottoNumbers.add(new LottoNumbers());
    }

    private void addLottoNumbers(List<Integer> numbers) {
        this.lottoNumbers.add(new LottoNumbers(numbers));
    }
}
