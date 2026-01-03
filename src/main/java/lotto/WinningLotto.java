package lotto;

public record WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.numbers().contains(bonusNumber);
    }
}