package domain;

import util.Console;
import util.Generator;

import java.util.List;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) throws Exception {
        this.lottoNumbers = lottoNumbers;
        this.validationLottoNumbers();
    }

    private void validationLottoNumbers() throws Exception {
        this.checkLottoNumberCount();
        this.checkLottoNumberRange();
    }

    private void checkLottoNumberCount() throws Exception {
        if (this.lottoNumbers.size() != Generator.MAX_LOTTO_NUMBER_COUNT) {
            Console.print("당첨 번호는 6개 입니다.");
            throw new Exception();
        }
    }

    private void checkLottoNumberRange() throws Exception {
        for (Integer lottoNumber : this.lottoNumbers) {
            if (lottoNumber < Generator.MIN_LOTTO_NUMBER || lottoNumber > Generator.MAX_LOTTO_NUMBER) {
                Console.lottoRangeExceptionMessage();
                throw new Exception();
            }
        }
    }

    public boolean isContains(int winningNumber) {
        return this.lottoNumbers.contains(winningNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
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
}
