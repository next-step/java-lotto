package lotto.domain;

public class WinningNumber {
    public static final String ALREADY_EXIST_LOTTO_NUMBER = "입력하신 보너스 번호는 기본 당첨 번호입니다. 다시 입력해주세요.";

    private final LottoNumbers winningNumber;
    private final LottoNumber bonusNumber;

    public WinningNumber(LottoNumbers winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException(ALREADY_EXIST_LOTTO_NUMBER);
        }

        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public int containsCount(LottoNumbers lottoNumbers) {
        return this.winningNumber.containsCount(lottoNumbers);
    }

    public boolean isContainBonusNumber(LottoNumbers lottoNumbers) {
        return lottoNumbers.isContainNumber(bonusNumber);
    }
}
