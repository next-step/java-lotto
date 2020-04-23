package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;

    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validateLottoNumbers(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
        this.winningLotto = winningLotto;
    }

    private void validateLottoNumbers(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호 중복");
        }
    }

    public static WinningLotto of(Lotto winningLotto, int number) {
        return new WinningLotto(winningLotto, LottoNumber.of(number));
    }

    public Rank match(Lotto buyLotto) {
        boolean isContainsBonus = buyLotto.contains(bonusNumber);
        return Rank.valueOf(winningLotto.match(buyLotto), isContainsBonus);
    }

}
