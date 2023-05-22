package lotto.domain;

public class WinningNumber {
    private final Ticket winningNumber;
    private final BonusBall bonusBall;

    private WinningNumber(Ticket winningNumber, BonusBall bonusBall) {
        this.winningNumber = winningNumber;
        this.bonusBall = bonusBall;
    }

    public static WinningNumber of(Ticket winningNumber, BonusBall bonusBall) {
        return new WinningNumber(winningNumber, bonusBall);
    }

    public int countMatchingNumber(Ticket numbers) {
        return (int) winningNumber.getNumbers().stream()
                .filter(w -> numbers.contains(w))
                .count();
    }

    public boolean isBonusBallMatched(Ticket numbers) {
        return numbers.contains(bonusBall.getBonusBall());
    }
}
