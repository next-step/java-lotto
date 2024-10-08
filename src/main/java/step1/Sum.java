package step1;

import java.util.Objects;

public class Sum {
    private int sum;

    public Sum() {
        this(0);
    }

    public Sum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Sum sum1 = (Sum) o;
        return sum == sum1.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum);
    }
}
