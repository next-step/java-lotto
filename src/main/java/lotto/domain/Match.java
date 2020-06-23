package lotto.domain;

public enum Match {


    HAS(true, 1),
    EMPTY(false, 0);

    private boolean check;
    private int count;

    Match(boolean check, int count) {
        this.check = check;
        this.count = count;

    }

    public int getCount() {
        return this.count;
    }

    public boolean isCheck() {
        return this.check;
    }
}
