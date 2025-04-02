package lotto.domain;

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
        LottoNumber bonusNumber = LottoNumber.toLottoNumber(bonusText);

        return new WinningLottoNumbers(lottoNumber, bonusNumber);
    }
    public LottoRank lottoRank(LottoNumbers lottoNumbers) {
        int match = (int) this.winningNumbers.numbers()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
        boolean bonusMatch = lottoNumbers.contains(this.bonusNumber);
        
        return LottoRank.fromMatch(match, bonusMatch);
    }
}
