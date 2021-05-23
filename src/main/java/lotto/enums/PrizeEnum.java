package lotto.common;

import lotto.lotto.MatchedAnswer;

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

    public int income(MatchedAnswer matchAnswer) {
        return prize * matchAnswer.count(answer);
    }
}
