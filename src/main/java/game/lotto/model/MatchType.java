package game.lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum MatchType {
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000);

    private static final Map<Integer, MatchType> types;

    static {
        types = Arrays.stream(MatchType.values())
                        .collect(Collectors.toMap(type -> type.key, Function.identity()));
    }

    private int key;
    private int prize;
    private String message;

    MatchType(int key, int prize) {
        this.key = key;
        this.prize = prize;
        this.message = String.format("%d개 일치 (%d원)", key, prize);
    }

    public String getMessage() {
        return this.message;
    }

    public int getPrize() {
        return this.prize;
    }

    public static MatchType valueOf(int key) {
        if(!types.containsKey(key)) {
            throw new IllegalArgumentException("존재 하지 않는 키 입니다. 키 종류 : [3, 4, 5, 6]");
        }

        return types.get(key);
    }

    public static boolean containsKey(int key) {
        return types.containsKey(key);
    }
}
