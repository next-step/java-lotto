package lotto.domian;

import java.util.Arrays;

public enum Record {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000)
    ;

    private int matchingCount;
    private int money;

    Record(int matchingCount, int money) {
        this.matchingCount = matchingCount;
        this.money = money;
    }

    public static Record find(int matchingCount) {
        return Arrays.stream(Record.values())
                .filter(record -> record.matchingCount == matchingCount)
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("맞힌 갯수에 해당하는 당첨금이 없습니다.");
                });
    }


}
