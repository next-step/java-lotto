package lotto.domain;

public class WinningBall {

    private final LottoNumber number;
    private final boolean isBonus;

    public WinningBall(String number) {
        this(number, false);
    }

    public WinningBall(String number, boolean isBonus) {
        this(Integer.parseInt(number), isBonus);
    }

    public WinningBall(int number, boolean isBonus) {
        this.number = new LottoNumber(number);
        this.isBonus = isBonus;
    }

    public LottoNumber getNumber() {
        return number;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
