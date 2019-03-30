package domain;

import util.Generator;

import java.util.List;

public class LottoNumbers {
    private List<LottoNo> lottoNumbers;

    public LottoNumbers(List<LottoNo> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.validationLottoNumbers();
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
        boolean isContains = false;
        for (LottoNo lottoNumber : this.lottoNumbers) {
            if (lottoNumber.toString().equals(winningNumber.toString())) {
                isContains = true;
            }
        }
        return isContains;
    }

    public int calcMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (LottoNo lottoNumber : this.lottoNumbers) {
            if (lotto.isContains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
