package step2.domain.statistics;

import step2.vo.Rank;

import java.util.Objects;

public class Revenue {
    private long revenue;

    public Revenue() {
        this(0);
    }

    public Revenue(long revenue) {
        this.revenue = revenue;
    }

    public void add(Rank rank) {
        this.revenue += rank.winnings;
    }

    public ProfitRate calculateProfitRate(Amount amount) {
        return new ProfitRate(this.revenue / amount.price());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Revenue)) return false;
        Revenue revenue1 = (Revenue) o;
        return revenue == revenue1.revenue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(revenue);
    }

    @Override
    public String toString() {
        return "Revenue{" +
                "revenue=" + revenue +
                '}';
    }
}
