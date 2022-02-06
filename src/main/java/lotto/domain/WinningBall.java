package lotto.domain;

public class WinningBall {

    private final int number;
    private final boolean isBonus;

    public WinningBall(String number) {
        this(number, false);
    }

    public WinningBall(String number, boolean isBonus) {
        this(Integer.parseInt(number), isBonus);
    }

    public WinningBall(int number, boolean isBonus) {
        this.number = number;
        this.isBonus = isBonus;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
