package step2.domain;

import static step2.domain.Numbers.getLottoNos;
import static step2.domain.Numbers.getRandomNos;

public class Lotto {
    private Numbers lotteryInfo;

    private Lotto(Numbers lotteryInfo) {
        this.lotteryInfo = lotteryInfo;
    }

    public static Lotto ofLotto(Numbers lotteryInfo) {
        return new Lotto(lotteryInfo);
    }

    public static Lotto ofRandomLotto() {
        return new Lotto(getRandomNos());
    }

    public static Lotto ofLottoByDesignatedRange(int start, int end) {
        return new Lotto(getLottoNos(start, end));
    }

    public ScoreType addWinningInfos(WinnersNo winnersNo) {
        int hitNumber = this.hasNumber(winnersNo);
        boolean hasBonusNumber = hasBonusNumber(hitNumber, winnersNo.getBonusNumber());
        return hitNumber > 2 ? ScoreType.getScore(hitNumber, hasBonusNumber) : ScoreType.NONE;
    }

    protected int hasNumber(WinnersNo winnersNo) {
        int hitNumbers = 0;
        for (int number : winnersNo.getWinnersResultNos()) {
            hitNumbers = lotteryInfo.getLotteryInfo().contains(number) ? ++hitNumbers : hitNumbers;
        }
        return hitNumbers;
    }

    private boolean hasBonusNumber(int hitNumbers, int BonusNumber) {
        return hitNumbers == 5 && lotteryInfo.getLotteryInfo().contains(BonusNumber);
    }

    @Override
    public String toString() {
        return this.lotteryInfo.toString();
    }
}
