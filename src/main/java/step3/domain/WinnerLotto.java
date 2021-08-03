package step3.domain;

public class WinnerLotto {
    private Lotto lotto;
    private int bonus;

    private WinnerLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinnerLotto of(Lotto lotto, int bonus){
        return new WinnerLotto(lotto, bonus);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
