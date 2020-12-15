package lotto.domain;

import java.util.Arrays;

public enum WinType {
    THREE_MATCH(3, "3개 일치 (5000원)"),
    FOUR_MATCH(4, "4개 일치 (50000원)"),
    FIVE_MATCH(5, "5개 일치 (1500000원)"),
    SIX_MATCH(6, "6개 일치 (2000000000원)"),
    NO_MATCH(0, "일치하는 수 없음");

    private int matchCnt;
    private String desc;

    WinType(int matchCnt, String desc) {
        this.matchCnt = matchCnt;
        this.desc = desc;
    }
    public static WinType getByCnt(int cnt) {
        return Arrays.stream(values())
                .filter(v -> v.matchCnt == cnt)
                .findAny()
                .orElse(WinType.NO_MATCH);
    }
}
