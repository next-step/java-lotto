package lotto;

import java.util.Objects;

public class WinStatistics {
    private int three;
    private int four;
    private int five;
    private int six;

    public WinStatistics() {
        this.three = 0;
        this.four = 0;
        this.five = 0;
        this.six = 0;
    }

    public WinStatistics(int three, int four, int five, int six) {
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
    }

    public void save(int wins) {
        switch (wins) {
            case 3:
                this.three++;
                break;
            case 4:
                this.four++;
                break;
            case 5:
                this.five++;
                break;
            case 6:
                this.six++;
                break;
        }
    }

    @Override
    public String toString() {
        return "WinStatistics{" + "three=" + three + ", four=" + four + ", five=" + five + ", six=" + six + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinStatistics that = (WinStatistics) o;
        return three == that.three && four == that.four && five == that.five && six == that.six;
    }

    @Override
    public int hashCode() {
        return Objects.hash(three, four, five, six);
    }
}
