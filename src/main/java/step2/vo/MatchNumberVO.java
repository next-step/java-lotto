package step2.vo;

public enum MatchNumberVO {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    public int matchNumber;
    public long winnings;

    MatchNumberVO(int matchNumber, long winnings) {
        this.matchNumber = matchNumber;
        this.winnings = winnings;
    }

    public static boolean isContains(int matchCount) {
        for (MatchNumberVO matchNumberVO : MatchNumberVO.values()) {
            if (matchNumberVO.matchNumber == matchCount) { // todo indent
                return true;
            }
        }
        return false;
    }

    public static MatchNumberVO createMatchNumber(int matchCount) {
        for (MatchNumberVO matchNumberVO : MatchNumberVO.values()) {
            if (matchNumberVO.matchNumber == matchCount) { // todo indent
                return matchNumberVO;
            }
        }
        throw new RuntimeException("MatchNumber에 해당하는 값을 찾을 수 없습니다.");
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(matchNumber)
                .append("개 일치(")
                .append(winnings)
                .append("원)")
                .toString();
    }
}
