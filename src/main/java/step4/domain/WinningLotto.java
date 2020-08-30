package step4.domain;

public class WinningLotto {

    private final Lotto winningLottoNumber;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto winningLottoNumber, LottoNumber bonusBall) {
        matchBonusValidationCheck(winningLottoNumber, bonusBall);
        this.winningLottoNumber = winningLottoNumber;
        this.bonusBall = bonusBall;

    }

    private void matchBonusValidationCheck(Lotto winningLottoNumber, LottoNumber bonusBall) {
        if (matchBonus(winningLottoNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호에서 제외되어야 합니다.");
        }
    }

    private boolean matchBonus(Lotto lotto, LottoNumber bonusBall) {
        return lotto.getLottoNumber().stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.getLottoNumber().stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
    }

    public int winningCount(Lotto lotto) {
        return (int) lotto.getLottoNumber().stream()
                .filter(number -> winningLottoNumber.getLottoNumber().contains(number))
                .count();
    }
}
