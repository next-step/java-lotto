package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningLottoNumbers {

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;


    public WinningLottoNumbers(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if(lottoNumbers.numbers().contains(bonusNumber.number())) {
            throw new IllegalArgumentException("보너스 번호는 로또 당첨 번호에 포함될 수 없습니다.");
        }

        this.lottoNumbers = new LottoNumbers(lottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public static WinningLottoNumbers toLottoNumbers(String lottoNumbersText, String bonusText) {
        LottoNumbers lottoNumber = LottoNumbers.toLottoNumber(lottoNumbersText);
        LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(bonusText));

        return new WinningLottoNumbers(lottoNumber, bonusNumber);
    }
    public LottoRank lottoRank(LottoNumbers lottoNumbers) {
        Set<LottoNumber> numberSet = new HashSet<>(lottoNumbers.numbers());
        int match = (int) this.lottoNumbers.numbers()
                .stream()
                .filter(numberSet::contains)
                .count();

        boolean bonusMatch = numberSet.contains(this.bonusNumber);
        return LottoRank.fromMatch(match, bonusMatch);
    }
}
