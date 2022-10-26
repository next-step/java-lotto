package lotto.domain;

import java.util.List;

public class LottoResult {

    private final LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    public LottoResult(List<Integer> lottoNumbers, Integer bonusNumber) {
        this(lottoNumbers);
        this.bonusNumber = new LottoNumber(new LottoNumbers(lottoNumbers), bonusNumber);
    }

    public LottoResult(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber.getNumber();
    }

    public Rank getMatchCount(LottoResult winnerLottoResult) {
        int count = getCount(this, winnerLottoResult);
        boolean isBonus = getLottoNumbers().contains(winnerLottoResult.getBonusNumber());
        return Rank.valueOf(count, isBonus);
    }

    private int getCount(LottoResult lottoResult, LottoResult winnerLottoResult) {
        return (int) lottoResult.getLottoNumbers()
                .stream()
                .filter(winnerLottoResult.getLottoNumbers()::contains)
                .count();
    }

}
