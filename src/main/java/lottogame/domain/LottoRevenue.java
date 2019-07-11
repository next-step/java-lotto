package lottogame.domain;

public class LottoRevenue {
    private final static int SUB_POINT_ONE = 1;
    private final static int SUB_POINT_TWO = 2;

    private double revenue;

    LottoRevenue(double revenue){
        this.revenue = revenue;
    }

    public String judgeResult() {
        if (this.revenue > 1)
            return "이익";
        if (this.revenue == 1)
            return "본전";
        return "손해";
    }

    // 계산된 수익율을 퍼센티지로 표현 (소수 2자리까지/ 단, 소수 한자리 일경우 한자리만 표현되도록 )
    public Double getPercentOfRevenue() {
        String[] result = String.valueOf(this.revenue).split("\\.");
        String percent = null;
        if (result[1].length() == SUB_POINT_ONE)
            percent = result[0] + "." + result[1].substring(0, SUB_POINT_ONE);
        if (result[1].length() > SUB_POINT_ONE)
            percent = result[0] + "." + result[1].substring(0, SUB_POINT_TWO);
        return Double.parseDouble(percent);
    }
}
