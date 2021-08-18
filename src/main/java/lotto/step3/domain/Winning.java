package lotto.step3.domain;

public class Winning {
    private static final int COUNT = 1;
    private static final int NO_COUNT = 0;
    private Lottery winnerNumber;
    private LottoNumber bonusNumber;

    public Winning(Lottery winnerNumber, LottoNumber bonusNumber) {
        if (winnerNumber.getLottery().size() != Lottery.LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는" + Lottery.LOTTO_COUNT + "개 이어야 합니다.");
        }

        if (winnerNumber.getLottery().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 로또 번호에 없는 숫자 이어야 합니다.");
        }
        this.winnerNumber = winnerNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lottery lottery) {
        int countOfMatch = 0;
        for (LottoNumber number : lottery.getLottery()) {
            countOfMatch += containLottoNumber(number);
        }
        boolean isContainBonusBall = lottery.contains(bonusNumber);

        return Rank.getRankBy(countOfMatch, isContainBonusBall);
    }

    private int containLottoNumber(LottoNumber lottoNumber) {
        if (winnerNumber.contains(lottoNumber)) {
            return COUNT;
        }
        return NO_COUNT;
    }
}
