package step2.domain;

import step2.exception.IllegalLottoBonusNumberException;

import java.util.Set;

public class LottoBonusNumber {
    private final LottoNumber lottoBonusNumber;

    public LottoBonusNumber(int lottoBonusNumber, Set<LottoNumber> lottoNumbers) {
        lottoBonusNumberDuplicateCheck(lottoBonusNumber, lottoNumbers);

        this.lottoBonusNumber = LottoNumber.valueOf(lottoBonusNumber);
    }

    private void lottoBonusNumberDuplicateCheck(int lottoBonusNumber, Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.contains(LottoNumber.valueOf(lottoBonusNumber))) {
            throw new IllegalLottoBonusNumberException("로또 당첨번호와 일치합니다.");
        }
    }

    public LottoNumber getLottoBonusNumber() {
        return lottoBonusNumber;
    }

}
