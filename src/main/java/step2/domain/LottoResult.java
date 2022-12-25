package step2.domain;

public class LottoResult {

    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int fourth = 0;
    private int fifth = 0;
    private double revenue = 0;


    public void matchGrade(int matchCount, boolean matchBonus) {
        Grade grade = Grade.valueOf(matchCount, matchBonus);

        if (grade == Grade.FIRST) first++;
        if (grade == Grade.SECOND) second++;
        if (grade == Grade.THIRD) third++;
        if (grade == Grade.FOURTH) fourth++;
        if (grade == Grade.FIFTH) fifth++;
    }

    public void calculateRevenue(int buyCount) {
        double inputMoney = buyCount * 1000;
        int income = (first * Grade.FIRST.getWinningMoney()) + (second * Grade.SECOND.getWinningMoney()) + (third * Grade.THIRD.getWinningMoney()) + (fourth * Grade.FOURTH.getWinningMoney()) + (fifth * Grade.FIFTH.getWinningMoney());
        revenue = income / inputMoney;
    }

    public int getGradeCount(int grade) {
        int result = 0;

        if (grade == 1) result = first;
        if (grade == 2) result = second;
        if (grade == 3) result = third;
        if (grade == 4) result = fourth;
        if (grade == 5) result = fifth;

        return result;
    }

    public double getRevenue() {
        return Math.round(revenue * 100) / 100.0;
    }
}
