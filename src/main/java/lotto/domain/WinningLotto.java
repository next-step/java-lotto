package lotto.domain;

public class WinningLotto {
    private Lotto winner;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winner, int bonusNumber) {
        LottoNumber bonus = LottoNumber.of(bonusNumber);
        if (winner.matchBonus(bonus)) {
            throw new IllegalArgumentException("로또 당첨번호와 2등 보너스 번호는 중복될 수 없습니다.");
        }
        this.winner = winner;
        this.bonusNumber = bonus;
    }

    public WinningType findWinningType(Lotto compare) {
        return WinningType.valueOf(compare.countHits(winner), compare.matchBonus(bonusNumber));
    }
}
