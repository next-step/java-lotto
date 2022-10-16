package com.game.lotto.count;


public class Strike {

    private int count;

    public Strike() {
        this(0);
    }

    public Strike(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void addCount(int count) {
        this.count += count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Strike strike = (Strike) o;

        return count == strike.count;
    }

    @Override
    public int hashCode() {
        return count;
    }
}
