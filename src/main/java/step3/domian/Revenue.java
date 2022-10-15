package step3.domian;

import java.util.List;
import java.util.Objects;

public class Revenue {

    private int revenue;

    public Revenue(List<Integer> results) {
        int result = 0;
        result += (Prize.THREE_PRIZE.prizeMoney * results.get(Prize.THREE_PRIZE.position));
        result += (Prize.FOUR_PRIZE.prizeMoney * results.get(Prize.FOUR_PRIZE.position));
        result += (Prize.FIVE_PRIZE.prizeMoney * results.get(Prize.FIVE_PRIZE.position));
        result += (Prize.FIVE_BONUS_PRIZE.prizeMoney * results.get(Prize.FIVE_BONUS_PRIZE.position));
        result += (Prize.SIX_PRIZE.prizeMoney * results.get(Prize.SIX_PRIZE.position));
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
