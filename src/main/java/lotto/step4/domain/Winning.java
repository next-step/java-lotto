package lotto.step4.domain;

public class Winning {
    private Lottery winnerNumber;
    private LottoNumber bonusNumber;

    public Winning(Lottery winnerNumber, LottoNumber bonusNumber) {
        if (winnerNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 로또 번호에 없는 숫자 이어야 합니다.");
        }
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lottery lottery) {
        int countOfMatch = lottery.match(winnerNumber);
        boolean isContainBonusBall = lottery.contains(bonusNumber);

        return Rank.getRankBy(countOfMatch, isContainBonusBall);
    }


}
