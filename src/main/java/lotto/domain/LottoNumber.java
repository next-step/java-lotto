package lotto.domain;

import lotto.domain.constant.LottoRank;

import java.util.Arrays;
import java.util.List;

public class LottoNumber {

    private final LottoNumbers numbers;
    private final BonusNumber bonusNumber;

    public LottoNumber(Integer... numbers) {
        this(integerToLottoNumbers(numbers), new BonusNumber());
    }

    public LottoNumber(List<Integer> numbers, int bonusNumber) {
        this(integerToLottoNumbers(numbers), new BonusNumber(bonusNumber));
    }

    public LottoNumber(List<NumberElement> numbers) {
        this(new LottoNumbers(numbers), new BonusNumber());
    }

    public LottoNumber(LottoNumbers numbers, int bonusNumber) {
        this(numbers, new BonusNumber(bonusNumber));
    }

    public LottoNumber(LottoNumbers numbers, BonusNumber bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLottoNumber(List<LottoNumber> useLottoNumber) {
        LottoResult lottoResult = new LottoResult();

        for (LottoNumber lottoNumber : useLottoNumber) {
            lottoResult.putLottoResult(this.numbers.match(lottoNumber, this.bonusNumber));
        }

        return lottoResult;
    }

    private static LottoNumbers integerToLottoNumbers(Integer... numbers) {
        return new LottoNumbers(Arrays.stream(numbers)
                .map(NumberElement::new)
                .toList());
    }

    private static LottoNumbers integerToLottoNumbers(List<Integer> numbers) {
        return new LottoNumbers(numbers.stream()
                .map(NumberElement::new)
                .toList());
    }

    public LottoRank checkBonusNumber(BonusNumber bonusNumber) {
        return this.numbers.checkBonusNumber(bonusNumber) ? LottoRank.BONUS : LottoRank.SECOND;
    }

    public LottoNumbers getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
