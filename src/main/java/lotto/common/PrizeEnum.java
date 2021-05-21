package lotto.common;

import java.util.Map;

public enum PrizeEnum {
    FOURTH(3, 5000, "3개 일치 (5000원)- "),
    THIRD(4,50000, "4개 일치 (50000원)- "),
    SECOND(5,1500000, "5개 일치 (1500000원)- "),
    FIRST(6, 2000000000, "6개 일치 (2000000000원)- ");

    int answer;
    int prize;
    String message;

    PrizeEnum(int answer, int prize, String message) {
        this.answer = answer;
        this.prize = prize;
        this.message = message;
    }

    public void print(Map<Integer, Integer> matchAnswer) {
        System.out.println(message + matchAnswer.getOrDefault(answer, 0) + PrintMessage.ANSWER_UNIT.message());
    }

    public int prize(Map<Integer, Integer> matchAnswer) {
        return prize * matchAnswer.getOrDefault(answer, 0);
    }
}
