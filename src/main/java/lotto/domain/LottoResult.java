package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.List;

public class LottoResult {

    private static final String VALIDATE_BONUS_NUMBER = "보너스 볼은 지난 주 당첨 번호와 중복될 수 없습니다.";

    private final LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    public LottoResult(List<Integer> lottoNumbers, Integer bonusNumber) {
        this(lottoNumbers);
        this.bonusNumber = validateBonusNumber(new LottoNumbers(lottoNumbers), new LottoNumber(bonusNumber));
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

    private LottoNumber validateBonusNumber(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (!lottoNumbers.isValidBonusNumber(bonusNumber)) {
            throw new InvalidInputException(VALIDATE_BONUS_NUMBER);
        }
        return bonusNumber;
    }

}
