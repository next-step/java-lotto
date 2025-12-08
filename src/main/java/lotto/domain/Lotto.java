package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final LottoPrice price;
    private final List<LottoNumbers> lottoNumbers;

    public Lotto(LottoPrice price, List<LottoNumbers> lottoNumbers) {
        this.price = price;
        this.lottoNumbers = lottoNumbers;
    }

    public LottoResult getMatchResult(LottoNumbers winningNumbers) {
        LottoResult result = new LottoResult();

        for (LottoNumbers lottoNumbers : lottoNumbers) {
            LottoRank rank = lottoNumbers.getMatchedRank(winningNumbers);
            result.add(rank);
        }

        return result;
    }

    public double calculateProfit(int prize) {
        return price.getProfit(prize);
    }

    public String count() {
        return String.valueOf(price.count());
    }

    @Override
    public String toString() {
        return lottoNumbers.stream().map(LottoNumbers::toString).collect(Collectors.joining("\n"));
    }
}
