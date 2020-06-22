package lotto.domain;

public enum Match {

    HAS(true,1),
    EMPTY(false, 0);

    private boolean check;
    private int value;

    Match(boolean check, int value){
        this.check = check;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
