package lotto;

public enum MappingCode {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int count;
    private final int prizes;

    MappingCode(int count, int prizes){
        this.count = count;
        this.prizes = prizes;
    }

    public int getCount(){
        return this.count;
    }

    public int getPrizes(){
        return this.prizes;
    }
}
