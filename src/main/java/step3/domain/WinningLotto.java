package step3.domain;

public class WinningLotto {

    private Lotto winnerLotto;
    private int bonus;

    public WinningLotto(String lottoString) {
        this.winnerLotto = new Lotto(lottoString);
    }

    public WinningLotto(String lottoString, int bonus) {
        this.winnerLotto = new Lotto(lottoString);
        this.bonus = bonus;
    }

    public Lotto getWinnerLotto() {
        return winnerLotto;
    }

    public int getBonus() {
        return bonus;
    }

    public boolean contains(Integer number) {
        return winnerLotto.getLotto().contains(number);
    }


}
