package my.project.lotto.domain;

import java.text.DecimalFormat;

public class StatRecord {
    private double pf;

    private int first;
    private int third;
    private int fourth;
    private int fifth;

    public StatRecord() {
        this.pf = 0;
        this.first = 0;
        this.third = 0;
        this.fourth = 0;
        this.fifth = 0;
    }

    public void setRank(Win rank) {
        if (rank.getTitle() == 1) first++;
        else if (rank.getTitle() == 3) third++;
        else if (rank.getTitle() == 4) fourth++;
        else if (rank.getTitle() == 5) fifth++;
    }

    public int getFirst() {
        return first;
    }

    public int getThird() {
        return third;
    }

    public int getFourth() {
        return fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public void setProfit(double pf) {
        this.pf = pf;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return "총 수익률은 " + format.format(this.pf) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }

}
