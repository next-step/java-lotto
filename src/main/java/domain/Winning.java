package domain;

import view.InputWinningView;

public class Winning extends Lotto {
    private int bonus;

    public Winning(String numbers) {
        super(numbers);
    }

    public Winning(InputWinningView view) {
        super(view.getWinning());
    }

    public Winning(String number, int bouns) {
        super(number);
        this.bonus = bouns;
    }

    public int compare(Lotto lotto) {
        return (int) this.lottoNumbers.stream().filter(lotto::contains).count();
    }
}
