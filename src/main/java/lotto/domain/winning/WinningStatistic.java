package lotto.domain.winning;

import java.text.DecimalFormat;
import lotto.domain.lotto.PurchaseAmount;
import lotto.domain.grade.Grade;
import lotto.error.exception.NotExistGradeException;

public class WinningStatistic {

    private int firstGradeCount;

    private int secondGradeCount;

    private int thirdGradeCount;

    private int forthGradeCount;

    private PurchaseAmount purchaseAmount;

    public WinningStatistic(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getFirstGradeCount() {
        return firstGradeCount;
    }

    public int getSecondGradeCount() {
        return secondGradeCount;
    }

    public int getThirdGradeCount() {
        return thirdGradeCount;
    }

    public int getForthGradeCount() {
        return forthGradeCount;
    }

    public int getGradeCount(Grade grade) {
        if (grade == Grade.FIRST_GRADE)
            return firstGradeCount;

        if (grade == Grade.SECOND_GRADE)
            return secondGradeCount;

        if (grade == Grade.THIRD_GRADE)
            return thirdGradeCount;

        if (grade == Grade.FOUR_GRADE)
            return forthGradeCount;

        throw new NotExistGradeException(grade);
    }

    public void calculateWinningStatistic(Grade grade){
        if (grade == Grade.FIRST_GRADE){
            firstGradeCount++;
            return;
        }

        if (grade == Grade.SECOND_GRADE){
            secondGradeCount++;
            return;
        }

        if (grade == Grade.THIRD_GRADE){
            thirdGradeCount++;
            return;
        }

        if (grade == Grade.FOUR_GRADE){
            forthGradeCount++;
        }
    }

    public double calculateProfitRate(){
       int totalWinningAmount =
           (firstGradeCount * Grade.FIRST_GRADE.getPrizeMoney()) +
           (secondGradeCount * Grade.SECOND_GRADE.getPrizeMoney()) +
           (thirdGradeCount * Grade.THIRD_GRADE.getPrizeMoney()) +
           (forthGradeCount * Grade.FOUR_GRADE.getPrizeMoney());
        double profitRate = (double) totalWinningAmount / purchaseAmount.getPurchaseAmount();
        return Double.parseDouble(formattedProfitRate(Math.floor(profitRate * 100) / 100));
    }

    private String formattedProfitRate(double profitRate) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(profitRate);
    }
}
