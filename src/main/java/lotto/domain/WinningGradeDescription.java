package lotto.domain;

public class WinningGradeDescription {
    private String descrption;
    private Money prize;

    public WinningGradeDescription(String description, Money prize) {
        this.descrption = description;
        this.prize = prize;
    }

    public WinningGradeDescription() {
        this("", Money.ZERO);
    }

    public Integer getIntegerPrizeMoney() {
        return prize.toInteger();
    }
}
