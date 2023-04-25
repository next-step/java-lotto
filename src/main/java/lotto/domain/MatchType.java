package lotto.domain;

public enum MatchType {
    THREE("3개 일치 (5000원)", 0),
    FOUR("4개 일치 (50000원)", 1),
    FIVE("5개 일치 (1500000원)", 2),
    SIX("6개 일치 (2000000000원)", 3);

    private final String phrase;
    private final int matchCountIdx;

    MatchType(String phrase, int matchCountIdx) {
        this.phrase = phrase;
        this.matchCountIdx = matchCountIdx;
    }

    public String phrase() {
        return phrase;
    }

    public int matchCountIdx() {
        return matchCountIdx;
    }
}
