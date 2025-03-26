package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public enum Division {
    FIFTH(3, 5000, "3개 일치 (5000원)- "),
    FORTH(4, 50000, "4개 일치 (50000원)- "),
    THIRD(5, 1500000, "5개 일치 (1500000원)- "),
    FIRST(6, 2000000000, "6개 일치 (2000000000원)- ");

    private int matchCount;
    private int prize;
    private String printMessage;

    private static Map<Division, Integer> matchCountMap = new EnumMap<>(Division.class);

    static {
        for (Division division : Division.values()) {
            matchCountMap.put(division, 0);
        }
    }

    private Division(int matchCount, int prize, String printMessage) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.printMessage = printMessage;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrintMessage() {
        return printMessage;
    }

    public static Division getDivision(int matchCount) {
        return Arrays.stream(values())
                .filter(division -> division.matchCount == matchCount)
                .findFirst()
                .map(division -> {
                    matchCountMap.put(division, matchCountMap.get(division) + 1);
                    return division;
                })
                .orElse(null);
    }

    public static Map<Division, Integer> getMatchCountMap() {
        return matchCountMap;
    }
}
