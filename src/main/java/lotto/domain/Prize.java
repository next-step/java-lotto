package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FOURTH(3, "5000"),
    THIRD(4, "50000"),
    SECOND(5, "1500000"),
    FIRST(6, "2000000000");

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
