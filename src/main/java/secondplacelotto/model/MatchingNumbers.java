package secondplacelotto.model;

public enum MatchingNumbers {

    FIFTH("3",0, false),
    FOURTH("4",0, false),
    THIRD("5",0, false),
    SECOND("5",0, true),
    FIRST("6",0, false);

    private final String matchingNumber;
    private int matchingCount;
    private final boolean matchBonus;


    MatchingNumbers(String matchingNumber, int matchingCount, boolean matchBonus){
        this.matchingNumber = matchingNumber;
        this.matchingCount = matchingCount;
        this.matchBonus = matchBonus;
    }

    public static void addMatchingCount(String matchingNumber, BonusNumber bonusNumber) {
        for (MatchingNumbers rank : values()) {
            matchMatchingNumber(bonusNumber, rank, matchingNumber);
            matchBonus(bonusNumber, rank);
        }
    }

    private static void matchBonus(BonusNumber bonusNumber, MatchingNumbers rank) {
        if (bonusNumber.isMatching() && rank.matchingNumber.equals("5") && rank.matchBonus) {
            rank.matchingCount++;
            bonusNumber.refreshMatchingStatus();
        }
    }

    private static void matchMatchingNumber(BonusNumber bonusNumber, MatchingNumbers rank, String matchingNumber) {
        if (!(bonusNumber.isMatching()) && rank.matchingNumber.equals(matchingNumber) && !rank.matchBonus) {
            rank.matchingCount++;
        }
    }

    public static int getMatchingCount(int index) {
        return values()[index].matchingCount;
    }

    public static int getMatchingNumbersCount() {
        return values().length;
    }

}
