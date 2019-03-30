package domain;

import util.Generator;

import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.validationLottoNumbers();
    }

    private void validationLottoNumbers() {
        this.checkLottoNumberCount();
        this.checkLottoNumberRange();
    }

    private void checkLottoNumberCount() {
        if (this.lottoNumbers.size() != Generator.MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
        }
    }

    private void checkLottoNumberRange() {
        for (Integer lottoNumber : this.lottoNumbers) {
            if (lottoNumber < Generator.MIN_LOTTO_NUMBER || lottoNumber > Generator.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("로또 범위를 벗어났습니다.");
            }
        }
    }

    public boolean isContains(int winningNumber) {
        return this.lottoNumbers.contains(winningNumber);
    }

    public int calcMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (Integer lottoNumber : this.lottoNumbers) {
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
