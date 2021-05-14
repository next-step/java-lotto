package lottoAuto.service;

import java.util.Arrays;
import java.util.function.Function;

public enum WinningCount {
    FIRST(6, 2000000000,"6개 일치 (2000000000원)"),
    SECOND(5, 30000000,"5개 일치, 보너스 볼 일치(30000000원)"),
    THIRD(5, 1500000,"5개 일치 (1500000원)"),
    FORTH(4, 50000,"4개 일치 (50000원)"),
    FIFTH(3, 5000,"3개 일치 (5000원)"),
    NO_MATCH(0,0,"일치 되는 거 없음");

    private int test;
    private int prize;
    private String message;

    WinningCount(int test, int prize,String message) {
        this.test = test;
        this.prize = prize;
        this.message = message;
    }
    public static WinningCount match(int winning_count, int bonus_count) {
        if (winning_count == bonus_count) {
            return SECOND;
        }
        return Arrays.stream(WinningCount.values())
                .filter(winningCount -> winningCount.test == winning_count)
                .findAny()
                .orElse(NO_MATCH);
    }

    public String getMessage() {
        return message;
    }

}
