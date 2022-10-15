package step3.domian;

import java.util.List;
import java.util.Objects;

public class Revenue {


    public static final int THREE_REVENUE = 5000;
    public static final int FOUR_REVENUE = 50000;
    public static final int FIVE_REVENUE = 1500000;
    public static final int SIX_REVENUE = 2000000000;


    private int revenue;

    public Revenue(List<Integer> results) {
        int result = 0;
        result += (THREE_REVENUE * results.get(3));
        result += (FOUR_REVENUE * results.get(4));
        result += (FIVE_REVENUE * results.get(5));
        result += (SIX_REVENUE * results.get(6));
        this.revenue = result;
    }

    public Revenue(int revenue) {
        this.revenue = revenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Revenue revenue1 = (Revenue) o;
        return revenue == revenue1.revenue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(revenue);
    }

    public float calculatePercentage(int lottoPrice) {
        return (float) this.revenue / (float) lottoPrice;
    }
}
