package step4.lotto.domain;

import java.util.Objects;

public class Count {
    private int count;

    public Count() {
        this.count = 0;
    }

    public Count(int count) {
        this.count = count;
    }

    public void plus(){
        this.count++;
    }

    public int getCount() {
        return count;
    }

    public boolean comapre(Count manualCount) {
        return Integer.compare(this.count, manualCount.getCount()) < 0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
