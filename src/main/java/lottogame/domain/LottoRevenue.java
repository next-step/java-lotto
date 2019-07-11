package lottogame.domain;

public class LottoRevenue {
    private double revenue;

    LottoRevenue(double revenue) {
        this.revenue = revenue;

    }

    public String judgeResult() {
        if (this.revenue > 1)
            return "이익";
        if (this.revenue == 1)
            return "본전";
        return "손해";
    }

    public double getRevenue() {
        return revenue;
    }
}
