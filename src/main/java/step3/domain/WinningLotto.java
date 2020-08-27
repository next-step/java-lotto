package step3.domain;

public class WinningLotto {

    private final Lotto winningLottoNumber;
    private final LottoNumber bonusBall;

    public WinningLotto(Lotto winningLottoNumber, LottoNumber bonusBall) {
        this.winningLottoNumber = winningLottoNumber;
        this.bonusBall = bonusBall;
        if (matchBonus(winningLottoNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호에서 제외되어야 합니다.");
        }
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.getLottoNumber().stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
    }

    public Lotto getWinningLottoNumber() {
        return winningLottoNumber;
    }

    public int winningCount(Lotto lotto) {
        return (int) lotto.getLottoNumber().stream()
                .filter(number -> winningLottoNumber.getLottoNumber().contains(number))
                .count();
    }
}
