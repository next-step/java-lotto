package lotto.domain;

import java.util.Arrays;

public enum WinType {
    THREE_MATCH(3, 5000, "3개 일치 (5000원)"),
    FOUR_MATCH(4, 50000, "4개 일치 (50000원)"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1500000원)"),
    BONUMS_MATCH(5, 30000000, "5개 일치, 보너스 볼 일치(30000000원)"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2000000000원)"),
    NO_MATCH(0, 0, "일치하는 수 없음");

    private final int matchCnt;
    private final int winnings;
    private final String desc;

    WinType(int matchCnt, int winnings, String desc) {
        this.winnings = winnings;
        this.matchCnt = matchCnt;
        this.desc = desc;
    }

    public static WinType valueOf(int cnt, boolean matchBonus) {
        if(cnt == 5 && matchBonus) {
            return BONUMS_MATCH;
        }

        return Arrays.stream(values())
                .filter(v -> v.matchCnt == cnt)
                .findFirst()
                .orElse(WinType.NO_MATCH);

    }

    public int getWinnings() {
        return winnings;
    }

    public String getDesc() {
        return desc;
    }
}
