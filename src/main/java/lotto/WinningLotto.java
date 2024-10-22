package lotto;

import java.util.List;

public class WinningLotto {
    LottoNumbers lottoNumbers;
    LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers, int bonusNumber) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers); //중복 숫자, 갯수 확인
        this.bonusNumber = new LottoNumber(bonusNumber); //숫자 범위 확인
        this.lottoNumbers.hasLottoNumber(this.bonusNumber); //이미 입력한 당첨번호 확인
    }

    public boolean hasLottoNumber(LottoNumber lottoNumber){
        return lottoNumbers.hasLottoNumber(lottoNumber);
    }

    public boolean checkBonusMatch(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

}
