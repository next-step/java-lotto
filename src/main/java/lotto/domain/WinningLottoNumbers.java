package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningLottoNumbers {

    private LottoNumbers winningNumbers;
    private LottoNumber bonusNumber;


    public WinningLottoNumbers(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if(winningNumbers.numbers().contains(bonusNumber.number())) {
            throw new IllegalArgumentException("보너스 번호는 로또 당첨 번호에 포함될 수 없습니다.");
        }

        this.winningNumbers = new LottoNumbers(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public static WinningLottoNumbers toLottoNumbers(String lottoNumbersText, String bonusText) {
        LottoNumbers lottoNumber = LottoNumbers.toLottoNumber(lottoNumbersText);
        LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(bonusText));

        return new WinningLottoNumbers(lottoNumber, bonusNumber);
    }
    public LottoRank lottoRank(LottoNumbers lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers.numbers());
        int match = (int) this.winningNumbers.numbers()
                .stream()
                .filter(lottoNumberSet::contains)
                .count();
        boolean bonusMatch = lottoNumberSet.contains(this.bonusNumber);
        
        return LottoRank.fromMatch(match, bonusMatch);
    }
}
