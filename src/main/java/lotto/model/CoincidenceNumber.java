package lotto.model;


import java.util.Arrays;

public enum CoincidenceNumber {
    three(3, 5000),
    four(4, 50000),
    five(5, 1500000),
    six(6, 2000000000);

    private int res;
    private final int coincidence;
    private final int price;

    CoincidenceNumber(int coincidence, int price) {
        this.coincidence = coincidence;
        this.price = price;
    }

    public int addRes(){
        this.res += 1;
        return this.res;
    }

    public int getRes(){
        return res;
    }

    public boolean isEqual(int coincidence){
        return this.coincidence == coincidence;
    }

    public static CoincidenceNumber of(int num){
        return Arrays.stream(CoincidenceNumber.values())
                .filter(op -> op.isEqual(num))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException(num + " :CoincidenceNumber 3~6 사이의 숫자만 입력 가능"));
    }

    public int getPrice() {
        return price;
    }
}
