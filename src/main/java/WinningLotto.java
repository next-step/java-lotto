import java.util.List;

public class WinningLotto {
    private List<Integer> lotto;
    private int bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
