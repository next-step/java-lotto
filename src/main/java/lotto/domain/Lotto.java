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

    public void sellLotto(long amount) {
        while (amount >= PRICE) {
            this.lottoNumbers.add(new LottoNumbers());
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

    int lottoNumbersCount() {
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
}
