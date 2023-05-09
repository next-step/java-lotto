package lotto.domian;

public class WinNumber {

    private final Lotto winNumber;

    public WinNumber(Lotto lotto) {
        this.winNumber = lotto;
    }

    public int distinguish(Lotto lotto) {
        return lotto.match(winNumber);
    }

}
