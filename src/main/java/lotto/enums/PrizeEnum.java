package lotto.common;

import java.util.Map;

public enum PrizeEnum {
    FOURTH(3, 5000),
    THIRD(4,50000),
    SECOND(5,1500000),
    FIRST(6, 2000000000);

    int answer;
    int prize;

    PrizeEnum(int answer, int prize) {
        this.answer = answer;
        this.prize = prize;
    }

    public int answer() {
        return answer;
    }

    public int prize() {
        return prize;
    }

    public int income(Map<Integer, Integer> matchAnswer) {
        return prize * matchAnswer.getOrDefault(answer, 0);
    }
}
