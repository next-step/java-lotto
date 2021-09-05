package step2.vo;

public enum MatchNumber {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    public int matchNumber;
    public long winnings;

    MatchNumber(int matchNumber, long winnings) {
        this.matchNumber = matchNumber;
        this.winnings = winnings;
    }

    public static boolean isContains(int matchCount) {
        for (MatchNumber matchNumber : MatchNumber.values()) {
            if (matchNumber.matchNumber == matchCount) { // todo indent
                return true;
            }
        }
        return false;
    }

    public static MatchNumber createMatchNumber(int matchCount) {
        for (MatchNumber matchNumber : MatchNumber.values()) {
            if (matchNumber.matchNumber == matchCount) { // todo indent
                return matchNumber;
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
