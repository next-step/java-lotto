package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FOURTH(3, "(5000원)"),
    THIRD(4, "(50000원)"),
    SECOND(5, "(1500000원)"),
    FIRST(6, "(2000000000원)");

    private int rank;
    private String money;

    Prize(int rank, String money) {
        this.rank = rank;
        this.money = money;

    }

    public int getRank() {
        return rank;
    }

    public String getMoney(){
        return money;
    }

    public static Prize findByMoney(int rank){
        return Arrays.stream(values())
                .filter(prize -> prize.getRank() == rank)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


}
