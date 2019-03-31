package domain;

import util.Generator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNo> lottoNumbers;

    private LottoNumbers(List<LottoNo> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.validationLottoNumbers();
    }

    public static LottoNumbers convertToLottoNo(List<Integer> numbers) {
        return new LottoNumbers(numbers.stream().map(number -> LottoNo.of(number)).collect(Collectors.toList()));
    }

    private void validationLottoNumbers() {
        this.checkLottoNumberCount();
    }

    private void checkLottoNumberCount() {
        if (this.lottoNumbers.size() != Generator.MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
        }
    }

    public boolean isContains(LottoNo winningNumber) {
        return this.lottoNumbers.contains(winningNumber);
    }

    public int calcMatchCount(Lotto lotto) {
        return lotto.matchCount(this.lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
