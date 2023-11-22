package lottoModel;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {

    private final int fifthCount;
    private final int fourthCount;
    private final int thirdCount;
    private final int secondCount;
    private final int firstCount;
    private final double rateOfReturn;
    public static final double RATE_OF_RETURN = 0.0;

    public LottoResult(int fifthCount, int fourthCount, int thirdCount, int secondCount, int firstCount, double rateOfReturn) {
        this.fifthCount = fifthCount;
        this.fourthCount = fourthCount;
        this.thirdCount = thirdCount;
        this.secondCount = secondCount;
        this.firstCount = firstCount;
        this.rateOfReturn = rateOfReturn;
    }

    public int getFifthCount() {
        return fifthCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getFirstCount() {
        return firstCount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public static LottoResult result(int money, List<Lotto> lottos, List<Integer> lastLotto, int lottoBonusNumber) {
        List<Integer> lottoMatchResults = new ArrayList<>();
        int bonusMatchCount = 0;
        for (Lotto lotto : lottos) {
            int matchNumber = lotto.matchCount(lastLotto);
            lottoMatchResults.add(matchNumber);
            if (getBonusMatchCount(lottoBonusNumber, lotto, matchNumber)) {
                bonusMatchCount++;
            }
        }
        int fifthCount = getCount(lottoMatchResults, Rank.FIFTH.getCountOfMatch());
        int fourthCount = getCount(lottoMatchResults, Rank.FOURTH.getCountOfMatch());
        int thirdCount = getCount(lottoMatchResults, Rank.THIRD.getCountOfMatch()) - bonusMatchCount;
        int secondCount = bonusMatchCount;
        int firstCount = getCount(lottoMatchResults, Rank.FIRST.getCountOfMatch());
        double rateOfReturn = rate(fifthCount, fourthCount, thirdCount, secondCount, firstCount, money);
        LottoResult lottoResult = new LottoResult(fifthCount, fourthCount, thirdCount, secondCount, firstCount, rateOfReturn);
        return lottoResult;
    }

    private static boolean getBonusMatchCount(int lottoBonusNumber, Lotto lotto, int matchNumber) {
        if (matchNumber == Rank.SECOND.getCountOfMatch() && lotto.isContainBonus(lottoBonusNumber)) {
            return true;
        }
        return false;
    }

    private static int getCount(List<Integer> lottoMatchResults, int matchNum) {
        return (int) lottoMatchResults.stream().filter(number -> number == matchNum).count();
    }

    private static double rate(int fifthCount, int fourthCount, int thirdCount, int secondCount, int firstCount, int money) {
        LottoOperator calc = new LottoOperator();
        double rate = RATE_OF_RETURN;

        rate += calc.calculate(fifthCount, Rank.FIFTH.getWinningMoney(), LottoOperator.Operator.MULTIPLY);
        rate += calc.calculate(fourthCount, Rank.FOURTH.getWinningMoney(), LottoOperator.Operator.MULTIPLY);
        rate += calc.calculate(thirdCount, Rank.THIRD.getWinningMoney(), LottoOperator.Operator.MULTIPLY);
        rate += calc.calculate(secondCount, Rank.SECOND.getWinningMoney(), LottoOperator.Operator.MULTIPLY);
        rate += calc.calculate(firstCount, Rank.FIRST.getWinningMoney(), LottoOperator.Operator.MULTIPLY);
        rate = calc.calculate(rate, money, LottoOperator.Operator.MINUS);
        rate = calc.calculate(rate, money, LottoOperator.Operator.DIVIDE);

        return rate;
    }

}
